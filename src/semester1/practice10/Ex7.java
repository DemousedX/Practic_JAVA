package semester1.practice10;

public class Ex7 {

  static String escape(String s) {
    return s.replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\"", "&quot;");
  }

  abstract static class UiWidget {
    protected String id;
    protected int width, height;

    UiWidget(String id, int width, int height) {
      this.id = id;
      this.width = width;
      this.height = height;
    }

    String attributes() {
      return " id=\"" + escape(id) + "\" style=\"width:" + width + "px;height:" + height + "px\"";
    }

    public abstract String renderHtml();
  }

  static class ButtonWidget extends UiWidget {
    private final String label;

    ButtonWidget(String id, String label) {
      super(id, 150, 40);
      this.label = label;
    }

    @Override
    public String renderHtml() {
      return "<button" + attributes() + ">" + escape(label) + "</button>";
    }
  }

  static class TextInputWidget extends UiWidget {
    private final String placeholder;

    TextInputWidget(String id, String placeholder) {
      super(id, 250, 40);
      this.placeholder = placeholder;
    }

    @Override
    public String renderHtml() {
      return "<input" + attributes() + " placeholder=\"" + escape(placeholder) + "\">";
    }
  }

  static class ProgressBarWidget extends UiWidget {
    private final int progressPercent;

    ProgressBarWidget(String id, int progress) {
      super(id, 250, 20);
      progressPercent = Math.max(0, Math.min(100, progress));
    }

    @Override
    public String renderHtml() {
      return "<progress"
          + attributes()
          + " max=\"100\" value=\""
          + progressPercent
          + "\"></progress>";
    }
  }

  public static String buildPage(UiWidget[] pageElements) {
    StringBuilder html =
        new StringBuilder(
            "<!doctype html><html lang=\"uk\"><head><meta"
                + " charset=\"UTF-8\"><title>Компоненти</title></head><body>");
    for (UiWidget w : pageElements) html.append(w.renderHtml());
    return html.append("</body></html>").toString();
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();

    System.out.println(
        buildPage(
            new UiWidget[] {
              new ButtonWidget("save", "Зберегти"),
              new TextInputWidget("name", "Ім'я"),
              new ProgressBarWidget("progress", 65)
            }));
  }
}
