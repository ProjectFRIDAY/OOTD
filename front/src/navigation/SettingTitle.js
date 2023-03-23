import { Image, TouchableOpacity } from "react-native";
import { useNavigation } from "@react-navigation/core";

export default function LogoTitle() {
	const navigation = useNavigation();

	const Click = () => {
		navigation.navigate('SettingView')
	}

  return (
		<TouchableOpacity style={{width:24, height:24}} onPress={Click}>
			<Image 
      source={require("../../assets/images/SettingLogo.png")}
      style={{width:24, height: 24}}
    	></Image>
		</TouchableOpacity>
  );
}
