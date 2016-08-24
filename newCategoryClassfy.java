import com.oracle.tools.packager.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.*;

/**
 * Created by joyeongje on 2016. 8. 11..
 */
public class newCategoryClassfy {

    public static void loadFile() {

        String original;
        FileInputStream inputStream;
        FileOutputStream outputStream;

        // StringTokenizer st = new StringTokenizer(temp,",.·()''");
        // System.out.println("토큰의 개수" + st.countTokens() + "개");
        // while(st.hasMoreTokens()) {
        //     System.out.println(++count + " " + st.nextToken());
        // }
//
        //  String parseString[] = new String[2];
        //  String temp = "827679$패션의류$남성언더웨어/잠옷$팬티#[codes combine] [AK플라자][코데즈컴바인이너] 도트나염 남트렁크CAATK154DNV/다크네이비_P020936794";
        //  parseString = temp.split("#");
        //  System.out.println("z");

        // 단어수 세서 빈도수는 많은데 실질적으로 학습에 방해되는 단어들
        // 단어 빈도수를 세어주는 웹사이트 이용
        // 수동분류 x

      // String arrayList[] = {"[0-9]%","[0-9]","해외","카드","배송","할인","당일","발송","출고","쿠폰","즉시","무료","ak"
       // ,"black","white"};
        //String arrayList[] = {"[0"};

        String prntStr = "";

        String[] parseString = new String[2];
        try {
            BufferedReader in = new BufferedReader(new FileReader("/Users/joyeongje/Documents/testHyungtaso/src/main/resources/soma_train.txt"));
            //BufferedWriter out = new BufferedWriter(new FileWriter("/Users/joyeongje/Documents/testHyungtaso/src/main/resources/soma_train_deleteNoise.txt")); // 형태소 분석 안한버젼
            BufferedWriter out = new BufferedWriter(new FileWriter("/Users/joyeongje/Documents/testHyungtaso/src/main/resources/analyse_soma_train9.txt")); //7은 형태소분석 x
            while ((original = in.readLine()) != null) {

               // System.out.println(original + "*" + "\n");
                parseString = original.split("#");
               // System.out.println(parseString[1] + "%" + "\n");

                StringTokenizer tokenizer = new StringTokenizer(parseString[1], ",.[]()/-_%");

                prntStr = "";
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();

                    //  for (String each : arrayList) {
                    //     token = token.replaceAll(each,"");
                    // }
                    prntStr += (token + " ");
                }
                prntStr = prntStr.replaceAll("[\\d]","");
                prntStr = prntStr.trim();
               // parseString[1] = HyungtasoAnalyse.getHyungtasoString(prntStr); // 형태소
                prntStr = (parseString[0] + "$" + prntStr  + "\n");
                System.out.println(prntStr);
                out.write(prntStr);
                //System.out.println("\n" + prntStr);
            }
            in.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void deleteNoise(String originalStr) {

    }

    public static void main(String[] args) {
        loadFile();
    }


}
