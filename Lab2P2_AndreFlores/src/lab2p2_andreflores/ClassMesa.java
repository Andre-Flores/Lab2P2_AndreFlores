package lab2p2_andreflores;

public class ClassMesa {

        private int numPlatos;
        private int numUtensilios;
        private double precioTotal;

        public ClassMesa(int numPlatos, int numUtensilios, double precioTotal) {
            this.numPlatos = numPlatos;
            this.numUtensilios = numUtensilios;
            this.precioTotal = precioTotal;
        }

        public int getNumPlatos() {
            return numPlatos;
        }

        public void setNumPlatos(int numPlatos) {
            this.numPlatos = numPlatos;
        }

        public int getNumUtensilios() {
            return numUtensilios;
        }

        public void setNumUtensilios(int numUtensilios) {
            this.numUtensilios = numUtensilios;
        }

        public double getPrecioTotal() {
            return precioTotal;
        }

        public void setPrecioTotal(double precioTotal) {
            this.precioTotal = precioTotal;
        }

        @Override
        public String toString() {
            return "Mesa{"
                    + "numPlatos=" + numPlatos
                    + ", numUtensilios=" + numUtensilios
                    + ", precioTotal=" + precioTotal
                    + '}';
        }
    }


