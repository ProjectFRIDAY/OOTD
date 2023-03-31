import {
  Text,
  View,
  StyleSheet,
  TouchableOpacity,
  ScrollView,
  FlatList,
  Image,
<<<<<<< HEAD
=======
  Alert, 
>>>>>>> 44b391c9e3021185149cc32bff239cfa2ffffa28
} from "react-native";
import React, { useEffect, useState } from "react";
import { useFocusEffect } from "@react-navigation/native";
import FeedList from "./FeedList";
<<<<<<< HEAD
import { getMyData } from "../api/api";

export default function ProfileView({ navigation }) {
  const [myProfileData, setMyProfileData] = useState({});

  const handleSetMyProfileData = (res) => {
    setMyProfileData(res);
  };

  useFocusEffect(
    React.useCallback(() => {
      getMyData(navigation, handleSetMyProfileData);
      // console.log(res);
    }, [])
  );

=======
import { useNavigation } from "@react-navigation/core";

export default function ProfileView( ) {  
  const navigation = useNavigation()
  
>>>>>>> 44b391c9e3021185149cc32bff239cfa2ffffa28
  return (
    <View style={sytles.container}>
      <FlatList
        ListHeaderComponent={
          <View>
            {/* <ScrollView stickyHeaderIndices={[2]}> */}
            <View style={sytles.backgroundImage}>

              {/* DropDownPicker로 수정 예정*/}
              <TouchableOpacity style={{
                width: 30, 
                marginTop: 10, 
                marginRight: 4, 
                alignSelf: 'flex-end'}}
              >
                <Image
                  source={require("../../assets/images/morebtn.png")}
                  style={{ width: 30, height: 24 }}
                />
              </TouchableOpacity>

            </View>
            <View style={sytles.profileImage}>
              {myProfileData?.userProfileImg ? (
                <Image source={myProfileData?.userProfileImg} />
              ) : (
                <Text
                  style={{
                    fontSize: 50,
                    color: "white",
                  }}
                >
                  {/* {myProfileData?.userName[0]?.toUpperCase()} */}
                </Text>
              )}
            </View>
            {/* 정보view */}
            <View
              style={{
                marginTop: 35,
              }}
            >
              <View
                style={{
                  backgroundColor: "white",
                  width: "100%",
                  padding: 25,
                  paddingTop: 15,
                  paddingBottom: 10,
                }}
              >
                <Text
                  style={{
                    fontSize: 30,
                    fontWeight: "bold",
                    marginBottom: 5,
                    color: "#2B4036",
                  }}
                >
                  {myProfileData?.userName}
                </Text>
                <Text style={{ marginBottom: 5, color: "#2B4036" }}>
                  @OOTD_Friday
                </Text>
                {/* 팔로우view */}
                <View
                  style={{
                    flexDirection: "row",
                    alignItems: "center",
                    justifyContent: "space-between",
                  }}
                >
                  <View style={{ flexDirection: "row", alignItems: "center" }}>
                    <Text
                      style={{
                        fontSize: 18,
                        fontWeight: "bold",
                        color: "#2B4036",
                      }}
                    >
                      {myProfileData?.followerCount}{" "}
                    </Text>
                    <Text style={{ color: "#2B4036", marginRight: 10 }}>
                      팔로워
                    </Text>
                    <Text
                      style={{
                        fontSize: 18,
                        fontWeight: "bold",
                        color: "#2B4036",
                      }}
                    >
                      {myProfileData?.followingCount}{" "}
                    </Text>
                    <Text>팔로잉</Text>
                  </View>
                  <TouchableOpacity
                  style={sytles.btn}
                  onPress={() => navigation.navigate('EditMyProfileView')}
                  >
                    <Text
                      style={{
                        fontSize: 13,
                        color: "#EFF1F0",
                        fontWeight: "bold",
                      }}
                    >
                      프로필 편집
                    </Text>
                  </TouchableOpacity>
                </View>
              </View>
            </View>
            <FeedList />
            {/* </ScrollView> */}
          </View>
        }
      />
    </View>
  );
}

const sytles = StyleSheet.create({
  container: {
    backgroundColor: "white",
    height: "100%",
  },
  backgroundImage: {
    backgroundColor: "#EFF1F0",
    height: 230,
    zIndex: 0,
    shadowColor: "#000",
    shadowOpacity: 0.2,
    shadowOffset: {
      width: 1,
      height: 1,
    },
  },
  profileImage: {
    position: "absolute",
    left: 30,
    top: 175,
    width: 90,
    height: 90,
    backgroundColor: "#2B4036",
    borderRadius: 50,
    alignItems: "center",
    justifyContent: "center",
  },
  btn: {
    backgroundColor: "#2B4036",
    width: 93,
    height: 30,
    borderRadius: 20,
    justifyContent: "center",
    alignItems: "center",
  },
});
