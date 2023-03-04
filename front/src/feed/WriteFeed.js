import React, { useEffect } from "react";
import { useState } from "react";
import {
  ScrollView,
  Text,
  View,
  StyleSheet,
  Image,
  TouchableOpacity,
  TextInput,
} from "react-native";
import RangePicker from "./RangePicker";
import UploadImageBtn from "../joinMembership/UploadImageBtn";
import CircleImageSelect from "../CircleImageSelect";
import { writeFeed } from "../api/api";

export default function WriteFeed({
  openDayModal,
  closeDayModal,
  selectedDate,
  navigation,
}) {
  const [title, setTitle] = useState("");

  const [subtitle, setSubTitle] = useState("");

  const [body, setBody] = useState("");

  const [imageUrl, setImageUrl] = useState("");

  const handleImageUrl = (imageUrl) => {
    setImageUrl(imageUrl);
  };

  return (
    <ScrollView style={styles.scrollView}>
      <View style={{ alignItems: "flex-end" }}>
        <View style={{ width: 120, zIndex: 1 }}>
          <RangePicker />
        </View>
      </View>
      <CircleImageSelect handleImageUrl={handleImageUrl} imageUrl={imageUrl} />
      <View style={styles.clickView}>
        <TouchableOpacity>
          <Image
            source={require("../../assets/images/share.png")}
            style={{ width: 19, height: 18, margin: 5, resizeMode: "contain" }}
          />
        </TouchableOpacity>
        <TouchableOpacity>
          <Image
            source={require("../../assets/images/delete.png")}
            style={{ width: 19, height: 21, margin: 5, resizeMode: "contain" }}
          />
        </TouchableOpacity>
      </View>
      <View style={{ alignItems: "center", paddingLeft: 10, paddingRight: 10 }}>
        <View style={styles.writeView}>
          <Image
            source={require("../../assets/images/twoline.png")}
            style={{ width: "100%", height: 5, resizeMode: "contain" }}
          />
          <TextInput
            placeholder="제목을 입력해주세요."
            placeholderTextColor={"#AFC2BA"}
            onChangeText={(text) => {
              setTitle(text);
            }}
            style={styles.titleText}
          />
          <Image
            source={require("../../assets/images/oneline.png")}
            style={{ width: "100%", height: 3, resizeMode: "contain" }}
          />
          <TextInput
            placeholder="ex) 상의 : 2WAY 베이직 아노락 후드"
            placeholderTextColor={"#AFC2BA"}
            onChangeText={(text) => {
              setSubTitle(text);
            }}
            style={styles.subTitleText}
          />
          <Image
            source={require("../../assets/images/oneline.png")}
            style={{ width: "100%", height: 3, resizeMode: "contain" }}
          />
          <TextInput
            placeholder="내용을 입력해주세요."
            placeholderTextColor={"#AFC2BA"}
            onChangeText={(text) => {
              setBody(text);
            }}
            style={styles.bodyText}
            multiline={true}
          />
          <Image
            source={require("../../assets/images/twoline.png")}
            style={{
              width: "100%",
              height: 5,
              resizeMode: "contain",
              position: "absolute",
              bottom: 10,
              alignSelf: "center",
            }}
          />
        </View>
      </View>
      <View style={{ alignItems: "flex-end" }}>
        <TouchableOpacity
          style={styles.completeBtn}
          onPress={() => {
            writeFeed(title, body, "ALL", imageUrl, navigation);
          }}
        >
          <Text style={{ textAlign: "center", color: "#EFF1F0" }}>완료</Text>
        </TouchableOpacity>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  scrollView: {
    width: "100%",
    height: "100%",
    padding: 12,
    paddingTop: 28,
  },
  clickView: {
    flexDirection: "row",
    justifyContent: "flex-end",
    alignItems: "center",
    margin: 15,
  },
  writeView: {
    backgroundColor: "#FFFFFF99",
    width: "100%",
    height: 330,
    borderRadius: 5,
    padding: 19,
  },
  titleText: {
    fontSize: 15,
    padding: 14,
    fontWeight: "bold",
    color: "#456A5A",
  },
  subTitleText: {
    fontSize: 12,
    padding: 14,
    fontWeight: "bold",
    color: "#456A5A",
  },
  bodyText: {
    fontSize: 12,
    padding: 14,
    color: "#456A5A",
    width: "100%",
    height: 200,
  },
  completeBtn: {
    width: 54,
    height: 25,
    borderRadius: 2,
    backgroundColor: "#456A5A",
    justifyContent: "center",
    alignItems: "center",
    marginTop: 17,
    marginRight: 16,
    marginBottom: 50,
  },
});
