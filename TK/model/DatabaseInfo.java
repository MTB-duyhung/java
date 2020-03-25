package Model;

public interface DatabaseInfo {
    public static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=FuLib;";
    //public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=FuLib;integratedSecurity=true;";    
    public static String userDB="sa";
    public static String passDB="123456";
}
