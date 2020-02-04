//
// Description: Implement a trapezoidal velocity profile.
//
// Always work in the interval [0,abs(T-X0)].
// When we are passed in a value X, transform it to x = abs(X-X0).
//
//
public class Planner {
    private double a    =  1.0;
    private double b    = -1.0;
    private double y0   =  0.01;
    private double ymax =  1.0;
    private double X0;
    private double T;
    private double x1, x2, xint;
    
    private boolean isTriangle = false;

    public Planner (double X0, double T) {
        this.X0 = X0;
        this.T  =  T;

        x1 = (ymax - y0)/a;
        x2 = ymax/b + Math.abs(T-X0);
        
        if (x1 > x2) {
            isTriangle = true;
            xint     = ((-b)*Math.abs(T-X0) - y0)/(a - b);
        }
    }      
    
    public double getRate (double X) {
        double x = Math.abs(X - X0);
        double rate;
        if (isTriangle) {
            if (x <= xint) {
                rate = (a*x + y0);
            } else {
                rate = b*(x - Math.abs(T-X0));
            }
        } else {
            if (x <= x1) {
                rate = (a*x + y0);
            } else if (x <= x2) {
                rate = ymax;
            } else {
                rate = b*(x - Math.abs(T-X0));
            }
        }
        return rate;
    }
}
