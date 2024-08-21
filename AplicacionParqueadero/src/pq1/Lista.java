package pq1;


/**
 * sambladz
 */
public class Lista {
    public Nodo nodoPrincipal;
    public int tamañoParqueadero=0;
    public int contCarro;
    public int contMoto;
    public int contCantidad = tamañoParqueadero;

    
    public void adicionarNodoFin(Nodo nodo){
        if (nodo != null){
            //si nodo tiene algo esta lleno sino no existe lista
            if (nodoPrincipal == null){
                this.nodoPrincipal = nodo;
            }else{
                Nodo aux = this.nodoPrincipal;
                while(aux.siguienteNodo != null){
                    aux = aux.siguienteNodo;
                }
                aux.siguienteNodo = nodo;
            }

        }
    }
    /**
     * imprime toda la lista
     * @return info Nodo
     */
    public String infoNodo(){
        String infoNodo="";
        infoNodo = "Placa: "+ this.nodoPrincipal.informacion.placa+ "\nTipo vehiculo: "+this.nodoPrincipal.informacion.vehiculo+"\nIdentificacion: "+this.nodoPrincipal.informacion.propietario.identificaion+"\nPropietario: "+this.nodoPrincipal.informacion.propietario.nombre;
        return infoNodo;
    }
    
    public String obtenerLista(){
        Nodo aux = this.nodoPrincipal;
        String listado = "";
        while (aux != null){
            listado+= aux.informacion+"\n";
            aux = aux.siguienteNodo;
        }
        return listado.toString();
    }
    /**
     * borra el primer nodo de la lista y la reorganiza, El nodo nodo 2 queda de primero.
     * Si solo hay uno queda vacia
     */
    public void borrarPrimero(Nodo nodo){
        if(nodo != null){
            if(nodoPrincipal.siguienteNodo == null){
                nodoPrincipal = null;
            }else{
                nodoPrincipal = nodoPrincipal.siguienteNodo;
            }
        }
    }
    
    public void borrarNodoPorPlaca(String placa) {
    if (nodoPrincipal == null) return; // Lista vacía

    // Si el nodo a eliminar es el primero
    if (nodoPrincipal.informacion.placa.equals(placa)) {
        nodoPrincipal = nodoPrincipal.siguienteNodo;
        return;
    }

    // Buscar el nodo previo al nodo a eliminar
    Nodo anterior = nodoPrincipal;
    Nodo actual = nodoPrincipal.siguienteNodo;

    while (actual != null && !actual.informacion.placa.equals(placa)) {
        anterior = actual;
        actual = actual.siguienteNodo;
    }

    // Si encontramos el nodo a eliminar
    if (actual != null) {
        anterior.siguienteNodo = actual.siguienteNodo;
    }
}

    public Nodo buscarNodoPorPlaca(String placa) {
    Nodo aux = this.nodoPrincipal;
    while (aux != null) {
        if (aux.informacion.placa.equals(placa)) {
            return aux;
        }
        aux = aux.siguienteNodo;
    }
    return null; // Si no se encuentra el nodo
}
    
}