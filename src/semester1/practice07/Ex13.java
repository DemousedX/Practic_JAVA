package semester1.practice07;

public class Ex13 {
  static class QueryBuilder {
    private String table, fields = "*", whereClause = "";

    public QueryBuilder(String table) {
      this.table = table;
    }

    public QueryBuilder select(String fields) {
      this.fields = fields;
      return this;
    }

    public QueryBuilder where(String condition) {
      whereClause = condition;
      return this;
    }

    public String build() {
      return "SELECT "
          + fields
          + " FROM "
          + table
          + (whereClause.isEmpty() ? "" : " WHERE " + whereClause)
          + ";";
    }
  }

  public static void main(String[] args) {
    semester1.ConsoleOutput.useUtf8();
    System.out.println(
        new QueryBuilder("users").select("id, name, email").where("age >= 18").build());
  }
}
