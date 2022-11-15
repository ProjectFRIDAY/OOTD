import { createNativeStackNavigator } from "@react-navigation/native-stack";
import JoinMembershipView from "../joinMembership/JoinMembershipView";
import LoginPage from "../loginpage/LoginPage";
import LogoTitle from "./LogoTitle";
import TabNavigation from "./TabNavigation";

const Stack = createNativeStackNavigator();

export default function StackNavigation() {
  return (
    <Stack.Navigator initialRouteName="Login">
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
    </Stack.Navigator>
  );
}