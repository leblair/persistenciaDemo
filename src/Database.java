public interface Database {

    void insertar(String title);

    void consultar();
    void consultarOne(String title);
    void deleteAll();
    void deleteOne(String title);
}
