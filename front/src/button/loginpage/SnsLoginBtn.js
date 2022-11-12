import { TouchableOpacity, Image } from "react-native";

export default function SnsLoginBtn({ SNS }) {
  const SNSLOGIN = {
    kakao: {
      picturesource: require("../../../assets/images/kakaologinbtn.png"),
    },
    naver: {
      picturesource: require("../../../assets/images/naverloginbtn.png"),
    },
    email: {
      picturesource: require("../../../assets/images/emailloginbtn.png"),
    },
  };
  return (
    <TouchableOpacity>
      <Image source={SNSLOGIN[SNS].picturesource}></Image>
    </TouchableOpacity>
  );
}
