package envique.challengeapp;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CMD_reader extends Main {

//    private static String uuidAsString;
    private static boolean sqlRun = false;//true = sensor aan. false = sensor uit

    public static String tail2(File file, int lines) {
        java.io.RandomAccessFile fileHandler = null;
        try {
            fileHandler =
                    new java.io.RandomAccessFile( file, "r" );
            long fileLength = fileHandler.length() - 1;
            StringBuilder sb = new StringBuilder();
            int line = 0;

            for(long filePointer = fileLength; filePointer != -1; filePointer--){
                fileHandler.seek( filePointer );
                int readByte = fileHandler.readByte();

                if( readByte == 0xA ) {
                    if (filePointer < fileLength) {
                        line = line + 1;
                    }
                } else if( readByte == 0xD ) {
                    if (filePointer < fileLength-1) {
                        line = line + 1;
                    }
                }
                if (line >= lines) {
                    break;
                }
                sb.append( ( char ) readByte );
            }

            String lastLine = sb.reverse().toString();
            return lastLine;
        } catch( java.io.FileNotFoundException e ) {
            e.printStackTrace();
            return null;
        } catch( java.io.IOException e ) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (fileHandler != null )
                try {
                    fileHandler.close();
                } catch (IOException e) {
                }
        }
    }

//    static int[] reverse(int a[], int n)
//    {
//        int[] b = new int[n];
//        int j = n;
//        for (int i = 0; i < n; i++) {
//            b[j - 1] = a[i];
//            j = j - 1;
//        }
//
//        // printing the reversed array
////        System.out.println("Reversed array is: \n");
////        for (int k = 0; k < n; k++) {
////            System.out.println(b[k]);
////        }
//        return b;
//    }


    private static DatabaseManager sqlFile;
    public CMD_reader(DatabaseManager sqlFile) {
        this.sqlFile = sqlFile;
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    public void updateScore(int eco2) {
        int score = -1;
        if (isBetween(eco2, 400, 500)) {
            if (eco2 <450) {
                score = 10;
            } else {
                score = 9;
            }
        } else if (isBetween(eco2, 501, 1000)) {
            if (eco2 <550) {
                score = 8;
            } else {
                score = 7;
            }
        } else if (isBetween(eco2, 1001, 2000)) {
            if (eco2 <1500) {
                score = 6;
            } else {
                score = 5;
            }
        } else if (isBetween(eco2, 2001, 5000)) {
            if (eco2 <3500) {
                score = 4;
            } else {
                score = 3;
            }
        } else if (isBetween(eco2, 5001, 999999999)) {
            if (eco2 <40000) {
                score = 2;
            } else {
                score = 1;
            }
        }
    }

    public static void main (String[] args) {

        int[] values = new int[2];
        File file = new File("G:\\logs\\log.txt");

//        String array = tail2(file, 2);
//        String strArray[] = array.split("\\n");
////        System.out.println(strArray);
//        for (int i = 0; i < strArray.length; i++) {
//            // Printing the elements of String array
////            System.out.print(strArray[i] + ", \n");
//            if (strArray[i].length() < 15) {
//                String temp[] = strArray[i].split("\\.");
//
//            }
//        }




        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {
                if (sqlRun) {
                    int teller = 0;

                    String array = tail2(file, 2);
                    String strArray[] = array.split("\\n");
                    for (int i = 0; i < strArray.length; i++) {
                        // Printing the elements of String array
                        System.out.print(strArray[i] + ", \n");

                        String temp[] = strArray[i].split(" ");
                        if (temp[1].toString().equals("Connection Lost")) {
                            System.out.println("Sensor disconnected");
                            sqlRun = false;
                        } else {
                            String temp2[] = temp[1].split("\\.");

//                        System.out.println("after: "+Integer.valueOf(temp2[0]));
                            values[teller] = Integer.valueOf(temp2[0]);
                            teller++;
                        }
                    }

                    System.out.println(values[1]);
//                    System.out.println(sqlFuncties.insertIntoDB(values[0], values[1]));
                    DatabaseManager.insertIntoDB(values[0], values[1]);
                }
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 900000);//1000 = 1sec, 15000 = 15sec, 900000 = 15 min

//        timer.cancel();

//        System.out.println(sqlFuncties.insertIntoDB(values[0], values[1]));
//        System.out.println(insertIntoDB(values[0], values[1]));
    }
}

//ToDo: de gegevens ook naar een score opzetten met een AQI formule