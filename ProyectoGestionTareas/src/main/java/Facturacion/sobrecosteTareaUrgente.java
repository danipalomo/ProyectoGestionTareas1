package Facturacion;

public class sobrecosteTareaUrgente implements Facturacion {
    double sobrecoste;
    double coste;
    public sobrecosteTareaUrgente(double sobrecoste, double coste){
        this.sobrecoste=sobrecoste;
        this.coste=coste;
    }

    @Override
    public double calcular() {
        return coste+sobrecoste;
    }
}
