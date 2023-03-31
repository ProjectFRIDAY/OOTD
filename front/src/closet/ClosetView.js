import {
  View,
  Text,
  FlatList,
  Image,
  ScrollView,
  StyleSheet,
  TouchableOpacity,
} from "react-native";
import ClosetSearchBar from "../input/ClosetSearchBar";
import ClosetFlatList from "./ClosetFlatList";
import { AntDesign } from "@expo/vector-icons";
import React, { useEffect, useState } from "react";
import { useFocusEffect } from "@react-navigation/native";
import { MaterialCommunityIcons } from "@expo/vector-icons";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { getDressList } from "../api/api";

export default function ClosetView({ navigation }) {
  const [isHashtag, setIsHashtag] = useState(true);
  const handleHashtag = () => {
    setIsHashtag(!isHashtag);
    const data = !isHashtag;
    AsyncStorage.setItem("isHashtag", data.toString());
  };

  useEffect(() => {
    const getData = async () => {
      try {
        const data = await AsyncStorage.getItem("isHashtag");
        if (data === "true") setIsHashtag(true);
        else setIsHashtag(false);
      } catch (e) {
        // console.log(e);
        console.log("hihihiihihihihih");
        setIsHashtag(true);
      }
    };
    getData();
  }, []);

  const [dressList, setDressList] = useState([]);
  const [outerFlatListData, setOuterFlatListData] = useState([]);
  const handleOuterFlatListData = (res) => {
    setOuterFlatListData((outerFlatListData) => [...outerFlatListData, res]);
  };
  const [topFlatListData, setTopFlatListData] = useState([]);
  const handleTopFlatListData = (res) => {
    setTopFlatListData((topFlatListData) => [...topFlatListData, res]);
  };
  const [bottomsFlatListData, setBottomsFlatListData] = useState([]);
  const handleBottomsFlatListData = (res) => {
    setBottomsFlatListData((bottomsFlatListData) => [
      ...bottomsFlatListData,
      res,
    ]);
  };
  const [shoesFlatListData, setShoesFlatListData] = useState([]);
  const handleShoesFlatListData = (res) => {
    setShoesFlatListData((shoesFlatListData) => [...shoesFlatListData, res]);
  };

  const handleSetDressList = (res) => {
    setDressList(res);
  };

  // useEffect(() => {

  // }, []);

  useFocusEffect(
    React.useCallback(() => {
      setOuterFlatListData([]);
      setTopFlatListData([]);
      setBottomsFlatListData([]);
      setShoesFlatListData([]);
      getDressList(
        navigation,
        handleOuterFlatListData,
        handleTopFlatListData,
        handleBottomsFlatListData,
        handleShoesFlatListData
      );
    }, [])
  );

  return (
    <>
      <View style={{ alignItems: "center", margin: 15 }}>
        <ClosetSearchBar />
      </View>
      <ScrollView>
        <View>
          <View
            style={{
              margin: 15,
              flexDirection: "row",
              justifyContent: "space-between",
            }}
          >
            <Text
              style={{
                fontSize: 17,
                fontWeight: "bold",
                marginBottom: 0,
              }}
            >
              아우터
            </Text>
            <TouchableOpacity
              onPress={() => handleHashtag()}
              style={{ flexDirection: "row", alignItems: "center" }}
            >
              {isHashtag ? (
                <Image
                  source={require("../../assets/images/checkHashtag.png")}
                />
              ) : (
                <MaterialCommunityIcons
                  name="circle-outline"
                  color={"#456A5A"}
                />
              )}
              <Text style={{ color: "#456A5A", marginLeft: 3 }}>
                해쉬태그 포함
              </Text>
            </TouchableOpacity>
          </View>
          <ClosetFlatList
            flatListData={outerFlatListData}
            navigation={navigation}
            isHashtag={isHashtag}
          />
        </View>
        <View>
          <Text
            style={{
              fontSize: 17,
              fontWeight: "bold",
              margin: 15,
              marginBottom: 0,
            }}
          >
            상의
          </Text>
          <ClosetFlatList
            flatListData={topFlatListData}
            navigation={navigation}
            isHashtag={isHashtag}
          />
        </View>
        <View>
          <Text
            style={{
              fontSize: 17,
              fontWeight: "bold",
              margin: 15,
              marginBottom: 0,
            }}
          >
            하의
          </Text>
          <ClosetFlatList
            flatListData={bottomsFlatListData}
            navigation={navigation}
            isHashtag={isHashtag}
          />
        </View>
        <View>
          <Text
            style={{
              fontSize: 17,
              fontWeight: "bold",
              margin: 15,
              marginBottom: 0,
            }}
          >
            신발
          </Text>
          <ClosetFlatList
            flatListData={shoesFlatListData}
            navigation={navigation}
            isHashtag={isHashtag}
          />
        </View>
        <View style={{ height: 90 }}></View>
      </ScrollView>
      <TouchableOpacity
        style={styles.plusBtn}
        onPress={() => navigation.navigate("AddCloth")}
      >
        <AntDesign name="plus" size={45} color="white" />
      </TouchableOpacity>
    </>
  );
}

const styles = StyleSheet.create({
  plusBtn: {
    width: 65,
    height: 65,
    backgroundColor: "#2B4036",
    position: "absolute",
    right: 20,
    bottom: "13%",
    borderRadius: 50,
    justifyContent: "center",
    alignItems: "center",
  },
});
