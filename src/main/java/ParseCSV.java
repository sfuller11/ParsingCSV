import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseCSV {

    public static void main(String[] args) {

        String file = "src\\real-estate-data.csv";
        BufferedReader reader = null;
        String line = "";
        double PriceSum = 0;
        double FootSum = 0;
        int MaxPrice = 0;
        int MinPrice = 99999999;
        int count = 0;

        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){

                String[] row = line.split(",");


                for(String index : row) {
                    if(index.equals("street")){
                        break;
                    }
                    else{
                        //System.out.printf("%10s", index);
                        int price = Integer.parseInt(row[9]);
                        int footage = Integer.parseInt(row[6]);
                        count++;
                        PriceSum += price;
                        FootSum += footage;

                        if(price  > MaxPrice){
                            MaxPrice = price;
                        }
                        if(MinPrice > price){
                            MinPrice = price;
                        }
                    }

                }
                System.out.println();
            }

            System.out.print("Average Price: " + PriceSum/count + "\n");
            System.out.print("Average Square Footage: " + FootSum/count + "\n");
            System.out.print("Minimum Price: " + MinPrice + "\n");
            System.out.print("Maximum Price: " + MaxPrice);



        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
