import { createNativeStackNavigator } from "@react-navigation/native-stack";
import JoinMembershipView from "../joinMembership/JoinMembershipView";
import LoginPage from "../loginpage/LoginPage";
import LogoTitle from "./LogoTitle";
import SettingTitle from "./SettingTitle";
import TabNavigation from "./TabNavigation";
import TabMiddleBtn from "./TabMiddleBtn";
import ClosetDetail from "../closet/CLosetDetail";
import ClosetView from "../closet/ClosetView";
import AddCloth from "../closet/AddCloth";
import Splash from "../Splash";
import WriteFeed from "../feed/WriteFeed";
import EditMyProfileView from "../profile/EditMyProfileView";
import SettingView from "../SettingView";
import NotifyView from "../profile/Notify/NotifyView";
import MyPage from "../profile/MyPage";
// import ForgotPasswordView from "../loginpage/ForgotPasswordView";

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
      {/* <Stack.Screen
        name="ForgotPasswordView"
        component={ForgotPasswordView}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
        }}
      ></Stack.Screen> */}
      <Stack.Screen
        name="MainPage"
        component={TabNavigation}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
          headerRight: (props) => <SettingTitle {...props} />,
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
      <Stack.Screen
        name="WriteFeed"
        component={WriteFeed}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
          headerBackVisible: false,
        }}
      ></Stack.Screen>
      <Stack.Screen
        name="MyPage"
        component={MyPage}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
          headerBackVisible: false,
        }}
      ></Stack.Screen>
      <Stack.Screen
        name="EditMyProfileView"
        component={EditMyProfileView}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
        }}
      ></Stack.Screen>
      <Stack.Screen
        name="SettingView"
        component={SettingView}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
        }}
      ></Stack.Screen>
      <Stack.Screen
        name="NotifyView"
        component={NotifyView}
        options={{
          headerStyle: {
            backgroundColor: "#3B5448",
          },
          headerTitle: (props) => <LogoTitle {...props} />,
        }}
      ></Stack.Screen>
    </Stack.Navigator>
  );
}
