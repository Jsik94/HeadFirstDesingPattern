package java_theory.collectionStudy;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import javax.swing.SortOrder;
/*
 *
 *
 */

//Comparable
/*
 *
 *
 *
 *
 */

class Address /* implements Comparable<Address> */ {

    // 정렬하기 위한 구분자 필드
    static int sortORDER = 1;

    String name;
    int age;
    String addr;
    String contact;

    public Address(String name, int age, String addr, String contact) {
        super();
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.contact = contact;
    }

    public Address() {
        this("UNKOWN", 20, "UNKOWN_ADDR", "NO_PHONE_NUMBER");
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Address [name=" + name + ", age=" + age + ", addr=" + addr + ", contact=" + contact + "]";
    }

    /*
     * Comparable 했을때
     *
     * @Override public int compareTo(Address o) { // TODO Auto-generated method
     * stub
     *
     * switch (sortORDER) { case 1:
     *
     * return this.name.compareTo(o.name); case 2:
     *
     * return this.age - o.age; case 3:
     *
     * return this.addr.compareTo(o.addr);
     *
     * }
     *
     *
     * return 0; }
     *
     */

}

public class AddressBookApp {

    // 익명클래스 활용

    private static void sortOrder(List<Address> a, int flag) {
        Collections.sort(a, new Comparator<Address>() {

            @Override
            public int compare(Address o1, Address o2) {
                switch (flag) {
                    case 1:

                        return o1.name.compareTo(o2.name);
                    case 2:

                        return o1.age - o2.age;
                    case 3:

                        return o1.name.compareTo(o2.addr);
                    default:
                        return o1.contact.compareTo(o2.contact);

                }

            }
        });
    }

    public static void main(String[] args) {
        /*
         * 1]자음을 Key값-String 혹은 Character List계열 컬렉션을 Value값-List<String> Map계열
         * 컬렉션-Value에는 자음에 해당하는 이름들 저장
         */
        Map<Character, List<String>> nameAddress = new HashMap<>();
        // 1-1]이름 저장용 List계열 컬렉션 객체 생성 및 이름 저장]
        List<String> kieyeok = Arrays.asList("고길동", "곽길동", "가길동", "기길동");
        List<String> nieoun = Arrays.asList("노길동", "나길동", "남길동");
        // 1-2]Map컬렉션(nameAddress)에 이름이 저장된 List계열 컬렉션 저장
        nameAddress.put('ㄱ', kieyeok);
        nameAddress.put('ㄴ', nieoun);
        // 1-3-1]키값을 알때
        System.out.println("[키값을 알때]");
        List<String> values = nameAddress.get('ㄱ');
        for (String value : values)
            System.out.println(value);
        // 1-3-2]키값을 모를때
        System.out.println("[키값을 모를때]");
        // 1]keySet()으로 Set컬렉션 얻기
        Set<Character> keys = nameAddress.keySet();
        // 2]Set컬렉션에 확장 for문 적용
        for (Character key : keys) {
            System.out.println(String.format("[%c로 시작하는 명단]", key));
            // 3]get(키값)으로 value얻기
            values = nameAddress.get(key);
            for (String value : values)
                System.out.println(value);
        }
        /*
         * 2]초성을 Key값-String 혹은 Character List계열 컬렉션을 Value값-List<Map<String,Object>>
         * Map계열 컬렉션-Value에는 초성에 해당하는 이름,주소,전화번호,나이들 저장
         */
        Map<Character, List<Map<String, Object>>> address = new HashMap<>();

        // 2-1]이름/전번/주소/나이가 저장된 맵 컬렉션을 저장할 리스트계열 컬렉션 객체 생성.
        List<Map<String, Object>> kie = new Vector<>();
        List<Map<String, Object>> nie = new Vector<>();
        // 2-2]이름/전번/주소/나이를 저장할 맵 컬렉션 객체 생성
        Map<String, Object> k = new HashMap<String, Object>();
        k.put("name", "고길동");
        k.put("age", 20);
        k.put("addr", "가산동");
        k.put("contact", "010-1234-5678");
        kie.add(k);
        k = new HashMap<String, Object>();
        k.put("name", "곽길동");
        k.put("age", 30);
        k.put("addr", "서초동");
        k.put("contact", "010-5678-5678");
        kie.add(k);

        Map<String, Object> n = new HashMap<String, Object>();
        n.put("name", "나길동");
        n.put("age", 25);
        n.put("addr", "나산동");
        n.put("contact", "010-9999-5678");
        nie.add(n);
        n = new HashMap<String, Object>();
        n.put("name", "노길동");
        n.put("age", 35);
        n.put("addr", "방배동");
        n.put("contact", "010-7777-5678");
        nie.add(n);
        // 주소록 저장하는 맵컬렉션에 리스트 저장]
        address.put('ㄱ', kie);
        address.put('ㄴ', nie);
        /*
         * 객체 꺼내올때] Set/List계열 무조건 확장 for문 사용 Map계열은 keySet()으로 키값들이 저장된 Set계열 반환 받은 후
         * 확장 for문 사용
         */
        System.out.println("[키값을 알때]");
        List<Map<String, Object>> lists = address.get('ㄱ');
        for (Map<String, Object> map : lists) {
            Set<String> set = map.keySet();
            for (String key : set) {
                Object value = map.get(key);
                System.out.println(String.format("%s:%s", key, value));
            }
        } ///////////////

        // 3] Arr

        Map<Character, List<Address>> addr_book = new HashMap<>();
        // k n c 시작의 정보 컬렉션 생성
        List<Address> kiec = new Vector<Address>();
        List<Address> niec = new Vector<Address>();
        List<Address> ciec = new Vector<Address>();
        //
        kiec.add(new Address("가길동", 40, "가산동", "010"));
        kiec.add(new Address("과길동", 30, "가산동 냥냥동", "016"));
        kiec.add(new Address("고길동", 20, "가산동 당당동", "019"));
        kiec.add(new Address("곡길동", 10, "가산동 랑랑동", "011"));

        niec.add(new Address("나길동", 40, "가산동", "078"));
        niec.add(new Address("너길동", 30, "가산동 냥냥동", "116"));
        niec.add(new Address("누길동", 20, "가산동 당당동", "119"));
        niec.add(new Address("난길동", 10, "가산동 랑랑동", "311"));

        ciec.add(new Address("카길동", 20, "가산동 당당동", "1132"));
        ciec.add(new Address("코길동", 10, "가산동 랑랑동", "3144"));

        addr_book.put('ㄱ', kiec);
        addr_book.put('ㄴ', niec);
        addr_book.put('ㅋ', ciec);

//		System.out.println("구현");
//
//		keys = addr_book.keySet();
//
//
//
//		for(Character key :keys) {
//			System.out.println(key+"로 시작하는 명단");
//			List<Address> vlas = addr_book.get(key);
//
////			Address.sortORDER =2 ;
////			Collections.sort(vlas, (o1,o2)->{
////				return ((Address)o1).name.compareTo(((Address)o2).name);
////			});
////
//
//			sortOrder(vlas, 2);
//
//
//			for(Address val : vlas) {
//				System.out.println(val.toString());
//			}
//
//		}

        /*
         * 이름을 입력받아 저장된 정보를 찾아내자
         *
         */
        System.out.println("★★★★★★★찾아봅시당 ★★★★★★★★★★");
        int cnt = 3;
        while (cnt-- > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("찾을 사람의 이름을 입력하세요");
            String target = sc.nextLine().trim();

            boolean toggle = false;

            System.out.println(CommonUtility.getFirstCharacter(target));
            List<Address> vlas = addr_book.getOrDefault(CommonUtility.getFirstCharacter(target), null);

            if(vlas !=null) {
                System.out.println("1");
                for (Address val : vlas) {
                    if (val.name.equals(target)) {
                        toggle = true;
                        System.out.println("찾았습니다!");
                        break;
                    }
                }
            }


            if (!toggle)
                System.out.println("해당 이름을 가진 사람이 없습니다.");

        }

    }////////////// main
}//////////////// class
