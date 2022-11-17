import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import MainPage from "../mainpage/MainPage";
import TabMiddleBtn from "./TabMiddleBtn";
import { MaterialCommunityIcons } from "@expo/vector-icons";
import FeedPage from "../feed/FeedPage";
import { useState } from "react";

const TabIcon = ({ name, size, color }) => {
  return <MaterialCommunityIcons name={name} size={size} color={color} />;
};

const Tab = createBottomTabNavigator();
export default function TabNavigation({ navigation }) {
  return (
    <Tab.Navigator initialRouteName=" ">
      <Tab.Screen
        name="Feed"
        component={FeedPage}
        options={{
          headerShown: false,
          tabBarActiveTintColor: "#2B4036",
          tabBarIcon: (props) => TabIcon({ ...props, name: "post-outline" }),
        }}
      />
      <Tab.Screen
        name=" "
        component={MainPage}
        options={{
          tabBarIcon: ({ focused }) => (
            <TabMiddleBtn navigation={navigation} isClick={focused} />
          ),
          headerShown: false,
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
