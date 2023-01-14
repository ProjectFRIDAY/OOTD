import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import MainPage from "../mainpage/MainPage";
import TabMiddleBtn from "./TabMiddleBtn";
import { MaterialCommunityIcons, Entypo, Ionicons } from "@expo/vector-icons";
import FeedPage from "../feed/FeedPage";
import ClosetView from "../closet/ClosetView";
import MyPage from "../mypage/MyPage";

const MaterialTabIcon = ({ name, size, color, focused }) => {
  return (
    <MaterialCommunityIcons
      name={name}
      size={size}
      color={color}
      style={focused ? { marginBottom: 10 } : {}}
    />
  );
};

const EntypoTabIcon = ({ name, size, color, focused }) => {
  return (
    <Entypo
      name={name}
      size={size}
      color={color}
      style={focused ? { marginBottom: 10 } : {}}
    />
  );
};

const IonTabIcon = ({ name, size, color, focused }) => {
  return (
    <Ionicons
      name={name}
      size={size}
      color={color}
      style={focused ? { marginBottom: 10 } : {}}
    />
  );
};

const Tab = createBottomTabNavigator();
export default function TabNavigation({ navigation }) {
  return (
    <Tab.Navigator
      initialRouteName="월간 켈린더"
      screenOptions={{
        tabBarStyle: { backgroundColor: "#2B4036", height: 89 },
      }}
    >
      <Tab.Screen
        name="월간 켈린더"
        component={MainPage}
        options={{
          headerShown: false,
          tabBarActiveTintColor: "#EFF1F0",
          tabBarInactiveTintColor: "#2B4036",
          tabBarIcon: (props) =>
            EntypoTabIcon({
              ...props,
              name: "calendar",
              color: "#EFF1F0",
              focused: props.focused,
            }),
        }}
      />
      <Tab.Screen
        name="게시물"
        component={FeedPage}
        options={{
          headerShown: false,
          tabBarActiveTintColor: "#EFF1F0",
          tabBarInactiveTintColor: "#2B4036",
          tabBarIcon: (props) =>
            MaterialTabIcon({
              ...props,
              name: "post-outline",
              color: "#EFF1F0",
              focused: props.focused,
            }),
        }}
      />
      <Tab.Screen
        name=" "
        component={MainPage}
        options={{
          tabBarInactiveTintColor: "#2B4036",
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
          tabBarActiveTintColor: "#EFF1F0",
          tabBarInactiveTintColor: "#2B4036",
          tabBarIcon: (props) =>
            MaterialTabIcon({
              ...props,
              name: "wardrobe-outline",
              color: "#EFF1F0",
              focused: props.focused,
            }),
        }}
      />
      <Tab.Screen
        name="마이페이지"
        component={MyPage}
        options={{
          headerShown: false,
          tabBarActiveTintColor: "#EFF1F0",
          tabBarInactiveTintColor: "#2B4036",
          tabBarIcon: (props) =>
            IonTabIcon({
              ...props,
              name: "person",
              color: "#EFF1F0",
              focused: props.focused,
            }),
        }}
      />
    </Tab.Navigator>
  );
}
