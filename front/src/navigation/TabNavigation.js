import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import MainPage from "../mainpage/MainPage";
import TabMiddleBtn from "./TabMiddleBtn";
import { MaterialCommunityIcons, Entypo } from "@expo/vector-icons";
import FeedPage from "../feed/FeedPage";
import ClosetView from "../closet/ClosetView";
import { useState } from "react";
import { TouchableOpacity } from "react-native";

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
        component={ClosetView}
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
