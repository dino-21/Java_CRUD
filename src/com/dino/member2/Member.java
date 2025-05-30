package com.dino.member2;

public class Member {
	private String memberId;
    private String name;
    private int age;

    public Member(String memberId, String name, int age) {
            this.memberId = memberId;
            this.name = name;
            this.age = age;
    }


    public String getMemberId() {
            return memberId;
    }


    public String getName() {
            return name;
    }


    public int getAge() {
            return age;
    }


    public void setAge(int age) {
            this.age = age;
    }


    public void setName(String name) {
            this.name = name;
    }
}
