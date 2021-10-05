package java_theory.streamStudy;

import java.util.HashSet;

public class ArrayListApp {
    public static void main(String[] args) {

        //map 과 같이 2demension (k,v)은 스트림이 없음
        /*
            범용 스트림생성
                -컬랙션 ->
                    Stream<T> 객체.stream();

                -배열
                    Stream<T> Arrays.of(T[]);
                    Stream<T> Arrays.stream(T[] array);
                    Stream<T> Arrays.stream(T[] array,int start,int end);

            주요 메서드
                -중간연산 메소드 (계속 사용가능, 리니지만 저장하기때문에)
                -최종연산 메소드 (한번 사용후 close)
                중간
                    distinct() 중복요소 제거
                    sorted(Comparator<? super E>)
                    filter(Predicate <T> predicate) 조건에 맞족하는 요소를 Stream으로 생성
                    limit(long maxSize)
                    skip(ling n):n개까지 요소를 제외한 스트림 생성
                    map

                최종
                    T reduce(T identity,BinaryOperator<T> accumulator)    ->  demension 변환 축소
                    void forEach(Consumer <? super T> action) -> 각요소에 지정된 작업 실행
                    long count() ->요소 갯수반환
                    Optional<T> 계열
                            max
                            sum
                            min
                            findAny ->랜덤 요소 반환
                            findFirst
         */

        HashSet hashSet = new HashSet();








    }
}
