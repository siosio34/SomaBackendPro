


import org.bitbucket.eunjeon.seunjeon.Analyzer;
import org.bitbucket.eunjeon.seunjeon.Eojeol;
import org.bitbucket.eunjeon.seunjeon.LNode;

import java.util.Arrays;

/**
 * Created by joyeongje on 2016. 8. 10..
 */
public class HyungtasoAnalyse {

    public static String getHyungtasoString(String readyString) { // 형태소를 나눈 문장들을 출력

        String completeString="";
        for (LNode node : Analyzer.parseJava(readyString)) {
            String temp = node.morpheme().copy$default$1();
            completeString += (temp + " ");
        }
        return completeString;
    }

    public static void main(String[] args) { // 샘플코드

        // 형태소 분석
        System.out.println("형태소 분석");
        for (LNode node : Analyzer.parseJava("펜티엄 하스웰 G3220")) {
            //node.morpheme().copy$default$1();
            String temp = node.morpheme().copy$default$1();
            System.out.println(temp);
        }



        // 어절 분석
        System.out.println("어절 분석");
        for (Eojeol eojeol: Analyzer.parseEojeolJava("펜티엄 하스웰 G3220")) {
            System.out.println(eojeol);
            for (LNode node: eojeol.nodesJava()) {
                System.out.println(node);
            }
        }

        /**
         * 사용자 사전 추가
         * surface,cost
         *   surface: 단어
         *   cost: 단어 출연 비용. 작을수록 출연할 확률이 높다.
         */
        Analyzer.setUserDict(Arrays.asList("덕후", "버카충,-100", "낄끼빠빠").iterator());
        for (LNode node : Analyzer.parseJava("덕후냄새가 난다.")) {
            System.out.println(node);
        }

        // 활용어 원형
        for (LNode node : Analyzer.parseJava("빨라짐")) {
            for (LNode node2: node.deInflectJava()) {
                System.out.println(node2);
            }
        }

        // 복합명사 분해
        for (LNode node : Analyzer.parseJava("펜티엄 하스웰 G3220")) {
            for (LNode node2: node.deCompoundJava()) {
                System.out.println(node2);
            }
        }
    }
}


