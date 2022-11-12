import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import JoinMembership from "../button/loginpage/JoinMembership";
import JoinMembershipView from "../joinMembership/JoinMembershipView";
import LoginPage from "../loginpage/LoginPage";
import LogoTitle from "./LogoTitle";

const Stack = createNativeStackNavigator();

const Navigation = () => {
  return (
    <NavigationContainer>
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
      </Stack.Navigator>
    </NavigationContainer>
  );
};
export default Navigation;
