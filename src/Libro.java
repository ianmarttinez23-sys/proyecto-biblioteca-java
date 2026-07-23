public class Libro {
    private String titulo;
    private String autor;
    private boolean estado; // True si está disponible False si ha sido prestado
    
    public Libro(String titulo, String autor, boolean estado){
        this.titulo = titulo;
        this.autor = autor;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
