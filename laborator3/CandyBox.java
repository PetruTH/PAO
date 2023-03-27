package laborator3;


import java.util.Objects;

public class CandyBox{
        protected String flavor;
        protected String origin;

        public CandyBox(){}
        public CandyBox(String a, String b){
            this.flavor = a;
            this.origin = b;
        }
        public float getVolume(){
            return 0;
        }
        public String toString(){
            return this.getClass().getName() + " flavor: " + this.flavor + ", origin: " + this.origin;
        }

    @Override
    public boolean equals(Object obj) {
        return this.flavor.equals(((CandyBox)obj).flavor)
                && this.origin.equals(((CandyBox)obj).origin);
    }

}
