package codingTestWithJava.kakao;

import java.util.List;
/*
After:  class Example<T> {
 	private T foo;
 	private final String bar;

 	private Example(T foo, String bar) {
 		this.foo = foo;
 		this.bar = bar;
 	}

 	public static <T> ExampleBuilder<T> builder() {
 		return new ExampleBuilder<T>();
 	}

 	public static class ExampleBuilder<T> {
 		private T foo;
 		private String bar;

 		private ExampleBuilder() {}

 		public ExampleBuilder foo(T foo) {
 			this.foo = foo;
 			return this;
 		}

 		public ExampleBuilder bar(String bar) {
 			this.bar = bar;
 			return this;
 		}

 		@java.lang.Override public String toString() {
 			return "ExampleBuilder(foo = " + foo + ", bar = " + bar + ")";
 		}

 		public Example build() {
 			return new Example(foo, bar);
 		}
 	}
 }





 */

public class ListPagingData<T> {


    private List<T> lists;
    private int totalRecordCount;
    private int pageSize;
    private int blockPage;
    private int nowPage;
    private String pagingString;


    private ListPagingData(Builder builder){
        this.lists = builder.lists;
        this.totalRecordCount = builder.totalRecordCount;
        this.pageSize = builder.pageSize;
        this.blockPage = builder.blockPage;
        this.nowPage = builder.nowPage;
        this.pagingString = builder.pagingString;
    }



    public static class Builder<T>{
        private List<T> lists;
        private int totalRecordCount;
        private int pageSize;
        private int blockPage;
        private int nowPage;
        private String pagingString;

        public Builder(){

        }

        public ListPagingData build(){
            return new ListPagingData(this);
        }

        public Builder setLists(List<T> lists) {
            this.lists = lists;
            return this;
        }

        public Builder setTotalRecordCount(int totalRecordCount) {
            this.totalRecordCount = totalRecordCount;
            return this;
        }

        public Builder setPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder setBlockPage(int blockPage) {
            this.blockPage = blockPage;
            return this;
        }

        public Builder setNowPage(int nowPage) {
            this.nowPage = nowPage;
            return this;
        }

        public Builder setPagingString(String pagingString) {
            this.pagingString = pagingString;
            return this;
        }
    }

}
