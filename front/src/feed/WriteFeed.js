import React from "react";
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
import * as ImagePicker from "expo-image-picker";

export default function WriteFeed({
  openDayModal,
  closeDayModal,
  selectedDate,
  navigation,
}) {
  const [status, requestPermission] = ImagePicker.useMediaLibraryPermissions();
  const [imageUrl, setImageUrl] = useState("");

  const uploadImage = async () => {
    if (!status?.granted) {
      const permission = await requestPermission();
      if (!permission.granted) {
        return null;
      }
    }
    const result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsEditing: true,
      quality: 1,
      aspect: [1, 1],
    });
    if (result.canceled) {
      return null;
    }
    // console.log(result.assets[0].uri);
    setImageUrl(result.assets[0].uri);
  };
  return (
    <ScrollView style={styles.scrollView}>
      <View style={{ alignItems: "flex-end" }}>
        <View style={{ width: 120, zIndex: 1 }}>
          <RangePicker />
        </View>
      </View>
      <View style={{ alignItems: "center" }}>
        <View style={styles.imageBox}>
          {imageUrl ? (
            <Image source={{ uri: imageUrl }} style={styles.imageBox} />
          ) : (
            <View
              style={[styles.imageBox, { backgroundColor: "white" }]}
            ></View>
          )}
        </View>
        <TouchableOpacity style={styles.uploadImage} onPress={uploadImage}>
          <Image source={require("../../assets/images/circlecamera.png")} />
        </TouchableOpacity>
      </View>
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
            style={styles.titleText}
          />
          <Image
            source={require("../../assets/images/oneline.png")}
            style={{ width: "100%", height: 3, resizeMode: "contain" }}
          />
          <TextInput
            placeholder="ex) 상의 : 2WAY 베이직 아노락 후드"
            placeholderTextColor={"#AFC2BA"}
            style={styles.subTitleText}
          />
          <Image
            source={require("../../assets/images/oneline.png")}
            style={{ width: "100%", height: 3, resizeMode: "contain" }}
          />
          <TextInput
            placeholder="내용을 입력해주세요."
            placeholderTextColor={"#AFC2BA"}
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
            navigation.goBack();
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
  imageBox: {
    width: 173,
    height: 173,
    borderRadius: 100,
    backgroundColor: "white",
  },
  uploadImage: {
    position: "absolute",
    top: 125,
    right: 125,
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
  },
});
