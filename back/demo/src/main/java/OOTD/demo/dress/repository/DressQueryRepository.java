package OOTD.demo.dress.repository;

import OOTD.demo.dress.Dress;
import OOTD.demo.user.User;

import java.util.Set;

public interface DressQueryRepository {

    Set<Dress> findDressByNameAndHashTag(User user, String searchStr);
}
