import { createNativeStackNavigator } from "@react-navigation/native-stack";
import JoinMembershipView from "../joinMembership/JoinMembershipView";
import LoginPage from "../loginpage/LoginPage";
import LogoTitle from "./LogoTitle";
import TabNavigation from "./TabNavigation";
import TabMiddleBtn from "./TabMiddleBtn";
import ClosetDetail from "../closet/CLosetDetail";
import ClosetView from "../closet/ClosetView";
import AddCloth from "../closet/AddCloth";
import Splash from "../Splash";

const Stack = createNativeStackNavigator();

export default function StackNavigation() {
  return (
    <Stack.Navigator initialRouteName="Splash">
      <Stack.Screen
        name="Splash"
        component={Splash}
        options={{ headerShown: false }}
      ></Stack.Screen>
      <Stack.Screen
        name="Login"
        component={LoginPage}
        options={{ headerShown: false }}
      ></Stack.Screen>
      <Stack.Screen
        name="JoinMembershipView"
        component={JoinMembershipView}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
        }}
      ></Stack.Screen>
      <Stack.Screen
        name="MainPage"
        component={TabNavigation}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
          headerBackVisible: false,
        }}
      ></Stack.Screen>
      <Stack.Screen name="TabMiddleBtn" component={TabMiddleBtn}></Stack.Screen>
      <Stack.Screen
        name="ClosetDetail"
        component={ClosetDetail}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
          headerBackTitle: "",
        }}
      ></Stack.Screen>
      <Stack.Screen name="CLosetView" component={ClosetView}></Stack.Screen>
      <Stack.Screen
        name="AddCloth"
        component={AddCloth}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: "의상 추가하기",
          headerTitleStyle: {
            color: "white",
            fontSize: 20,
          },
          headerBackTitle: "",
        }}
      ></Stack.Screen>
    </Stack.Navigator>
  );
}
