//import org.junit.rules.ExternalResource;
//import org.sql2o.*;
//
//public class DatabaseRule extends ExternalResource {
//
//    @Override
//    protected void before() {
//        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hero_squad_test", 'moringa', 1234);  //Those with linux or windows use two strings for username and password
//    }
//
//    @Override
//    protected void after() {
//        try(Connection con = DB.sql2o.open()) {
//            String deletePersonsQuery = "DELETE FROM persons *;";
//            con.createQuery(deletePersonsQuery).executeUpdate();
//        }
//    }
//
//}
