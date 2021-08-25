package com.mackenzie;

public class BST implements IBST<Empleado>{

    private Empleado valor;
    private BST izdo, dcho, padre;

    @Override
    public boolean esVacio() {
        return valor == null;
    }

    @Override
    public boolean esHoja() {
        boolean uno, dos, tres;
        uno = valor != null; // Aqui comprobamos que la lista no esta vacia
        dos = izdo == null; // Aqui comprobamos que no tiene un hijo izquierdo
        tres = dcho == null; // Aqui comprobamos que no tiene un hijo derecho
        return uno && dos && tres; // si los tres valores son verdaderos es una hoja y devolvemos true
    }

    private void insertImpl(Empleado empl, BST padre) {
        if (valor == null){
            this.valor = empl;
            this.padre = padre;
        } else {
            if (empl.compareTo(valor) < 0) {
                if (izdo == null) izdo = new BST(); // si izquierdo es nulo lo instanciamos
                izdo.insertImpl(empl, this); // agregamos empleado a la rama izquierda
            } else if (empl.compareTo(valor) > 0) {
                if (dcho == null) dcho = new BST(); // si derercho es nulo lo instanciamos
                dcho.insertImpl(empl, this);
            } else {
                // Aqui tenenemos dos id iguales y no se permiten dos id iguales
                // se puede gestionar lanzando un mensaje de error
                throw new RuntimeException("Insertando elemento duplicado");
            }
        }
    }

    @Override
    public void insert(Empleado empl) {
        insertImpl(empl, null);
    }

    @Override
    public boolean exists(int id) {
        if (valor != null) {
            if (id == valor.getId()) {
                return true;
            } else if (id < valor.getId() && izdo != null) {
                return izdo.exists(id);
            } else if (id > valor.getId() && dcho != null){
                return dcho.exists(id);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public Empleado obtener(int id) {
        if (valor != null) {
            if (id == valor.getId()) {
                return valor;
            } else if (id < valor.getId() && izdo != null) {
                return izdo.obtener(id);
            } else if (id > valor.getId() && dcho != null){
                return dcho.obtener(id);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public void preorden() {
        preordenImpl("");
    }



    @Override
    public void inorden() {
        inordenImpl("");
    }

    @Override
    public void postorden() {
        postordenImpl("");
    }

    @Override
    public void delete(int id) {
        if(valor != null) {
            if (id == valor.getId()) {
                // Eliminamos el valor Aqui
                deleteImpl(id);
            } else if (id < valor.getId() && izdo != null) {
                izdo.delete(id);
            } else if (id > valor.getId() && dcho != null) {
                dcho.delete(id);
            }
        }
    }

    private void preordenImpl(String prefijo) {
        if (valor != null) {
            System.out.println(prefijo + valor);
            if (izdo != null) izdo.preordenImpl(prefijo + "  ");
            if (dcho != null) dcho.preordenImpl(prefijo + "  ");
        }
    }

    private void inordenImpl(String prefijo) {
        if (valor != null) {
            if (izdo != null) izdo.inordenImpl(prefijo + "  ");
            System.out.println(prefijo + valor);
            if (dcho != null) dcho.inordenImpl(prefijo + "  ");
        }
    }

    private void postordenImpl(String prefijo) {
        if (valor != null) {
            if (izdo != null) izdo.postordenImpl(prefijo + "  ");
            if (dcho != null) dcho.postordenImpl(prefijo + "  ");
            System.out.println(prefijo + valor);
        }
    }

    private void deleteImpl(int id) {
        if (izdo != null && dcho != null) {
            // Aqui eliminamos teniendo dos hijos
            BST minimo = dcho.minimo();
            this.valor = minimo.valor;
            dcho.delete(minimo.valor.getId());
        } else if (izdo != null || dcho != null) {
            // Aqui eliminamos teniendo un hijo
            BST sustituto = izdo != null ? izdo : dcho;
            this.valor = sustituto.valor;
            this.izdo = sustituto.izdo;
            this.dcho = sustituto.dcho;
        } else {
            // Aqui eliminamos teniendo 0 hijos
            if (padre != null) {
                if (this == padre.izdo) padre.izdo = null;
                if (this == padre.dcho) padre.dcho = null;
                padre = null;
            }
            valor = null;
        }
    }

    private BST minimo() {
        if (izdo != null && !izdo.esVacio()) {
            return izdo.minimo();
        } else {
            return this;
        }
    }

}
