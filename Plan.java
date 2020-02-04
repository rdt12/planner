

class Plan {
      public static void main(String[] args) {
          double X0 = Double.parseDouble(args[0]);
          double T  = Double.parseDouble(args[1]);

          Planner planner = new Planner(X0, T);

          double step = (T-X0)/100;

//          System.out.println("X0 = " + X0);
//          System.out.println("T  = " + T);

          int i;
          double X;
          for (i=0; i<=100; i++) {
              X = X0 + i*step;
              System.out.printf("%.2f  %.2f\n",X, planner.getRate(X));
          }
          
      }            
}
