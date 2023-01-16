import {
  Text,
  View,
  StyleSheet,
  TouchableOpacity,
  ScrollView,
  FlatList,
} from "react-native";
import React, { useState } from "react";
import FeedList from "./FeedList";

export default function ProfileView() {
  return (
    <View style={sytles.container}>
      <FlatList
        ListHeaderComponent={
          <View>
            {/* <ScrollView stickyHeaderIndices={[2]}> */}
            <View style={sytles.backgroundImage}></View>
            <View style={sytles.profileImage}>
              <Text
                style={{
                  fontSize: 50,
                  color: "white",
                }}
              >
                S
              </Text>
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
                  닉네임
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
                      296{" "}
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
                      296{" "}
                    </Text>
                    <Text>팔로잉</Text>
                  </View>
                  <TouchableOpacity style={sytles.btn}>
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
