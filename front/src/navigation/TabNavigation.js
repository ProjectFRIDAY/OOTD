import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import MainPage from "../mainpage/MainPage";
import TabMiddleBtn from "./TabMiddleBtn";
import { MaterialCommunityIcons } from "@expo/vector-icons";

const TabIcon = ({ name, size, color }) => {
  return <MaterialCommunityIcons name={name} size={size} color={color} />;
};

const Tab = createBottomTabNavigator();

export default function TabNavigation() {
  return (
    <Tab.Navigator>
      <Tab.Screen
        name="Home"
        component={MainPage}
        options={{
          headerShown: false,
          tabBarActiveTintColor: "#2B4036",
          tabBarIcon: (props) => TabIcon({ ...props, name: "home" }),
        }}
      />
      <Tab.Screen
        name=" "
        component={EmptyScreen}
        options={{
          tabBarIcon: ({ focused }) => <TabMiddleBtn />,
        }}
      />
      <Tab.Screen
        name="Closet"
        component={Closet}
        options={{
          headerShown: false,
          tabBarActiveTintColor: "#2B4036",
          tabBarIcon: (props) =>
            TabIcon({ ...props, name: "wardrobe-outline" }),
        }}
      />
    </Tab.Navigator>
  );
}

function EmptyScreen() {
  return <></>;
}

function Closet() {
  return <></>;
}
