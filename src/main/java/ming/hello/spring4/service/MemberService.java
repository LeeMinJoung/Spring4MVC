package ming.hello.spring4.service;

import ming.hello.spring4.model.Member;

public interface MemberService {

    boolean saveMember(Member m);
    boolean loginMember(Member m);

    Member readOneMember(String userid);

}
