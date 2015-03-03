package utilities;

/**
 * Created by jay on 2/24/15.
 */
public class Tire {
    String tireSize;
    int height;
    int rimSize;
    int width;
    int year;
    double thread;

    public Tire(){
        System.out.println("Please renter a tire size");
    }

    public Tire(String tireSize){
        if(!checkNumber(tireSize)){
            System.out.println("Numero Incorrecto");
        }else{
            System.out.println("Numero Correcto");
            parseIntoSpecificSizes(tireSize);
        }

    }
    public void parseIntoSpecificSizes(String tireSize){
        StringBuffer sb=new StringBuffer();
        for(int j=0;j<3;j++){
            int k=Integer.valueOf(String.valueOf(tireSize.charAt(j)));
            sb.append(k);
            if(j==2){
                int r=Integer.parseInt(sb.toString());
                height=r;
                System.out.println(height);
            }
        }
        sb.delete(0,sb.length());
        for(int k=3;k<5;k++){
            int s=Integer.valueOf(String.valueOf(tireSize.charAt(k)));
            sb.append(s);
            if(k==4){
                int r=Integer.parseInt(sb.toString());
                width=r;
                System.out.println(width);
            }

        }
        sb.delete(0,sb.length());
        for(int l=5;l<7;l++){
            int s=Integer.valueOf(String.valueOf(tireSize.charAt(l)));
            sb.append(s);
            if(l==6){
                int r=Integer.parseInt(sb.toString());
                rimSize=r;
                System.out.println(rimSize);
            }
        }
    }

    public boolean checkNumber(String x){
        if(x.matches("^[0-9]+$")){
            return true;
        }


        return false;
    }

    public void setHeight(){}
    public void setRimSize(){}
    public void setWidth(){}


    public void setYear(int year) {
        this.year = year;
    }
    public void setThread(double thread) {
        this.thread = thread;
    }
    public int getHeight() {

        return height;
    }
    public int getWidth() {

        return width;
    }
    public int getRimSize() {

        return rimSize;
    }
    public int getYear() {
        return year;
    }
    public double getThread() {
        return thread;
    }

}