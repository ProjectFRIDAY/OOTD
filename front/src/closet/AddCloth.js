import {
  View,
  Text,
  TouchableOpacity,
  TextInput,
  ScrollView,
  StyleSheet,
  Image,
  Platform,
  KeyboardAvoidingView,
  NativeModules,
} from "react-native";
// import { Picker } from "@react-native-picker/picker";
import { useEffect, useState } from "react";
import * as ImagePicker from "expo-image-picker";
import { AntDesign } from "@expo/vector-icons";
import CategoryPicker from "./CategoryPicker";
import HashTagPicker from "./HashTagPicker";
import { addDress } from "../api/api";

const { StatusBarManager } = NativeModules;

export default function AddCloth({ navigation }) {
  const [status, requestPermission] = ImagePicker.useMediaLibraryPermissions();
  const [imageUrl, setImageUrl] = useState("");
  const formData = new FormData();

  const [form, setForm] = useState({});

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
    setImageUrl(result.assets[0].uri);
    const imageUri = result.assets[0].uri;
    const filename = imageUri.split("/").pop();
    const match = /\.(\w+)$/.exec(filename ?? "");
    const type = match ? `image/${match[1]}` : `image`;
    // const formData = new FormData();
    formData.append("image", { uri: imageUri, name: filename, type });
    setForm(formData);
  };
  useEffect(() => {
    Platform.OS == "ios"
      ? StatusBarManager.getHeight((statusBarFrameData) => {
          setStatusBarHeight(statusBarFrameData.height);
        })
      : null;
  }, []);

  useEffect(() => {
    console.log(form);
  });

  const [statusBarHeight, setStatusBarHeight] = useState(0);

  const [dressName, setDressName] = useState("");
  const changeDressName = (text) => {
    setDressName(text);
  };

  const [hashTag, setHashTag] = useState([]);
  const changeHashTag = (arr) => {
    setHashTag(arr);
  };

  return (
    <KeyboardAvoidingView
      style={styles.keyboard}
      keyboardVerticalOffset={statusBarHeight + 44}
      behavior={"padding"}
    >
      <ScrollView>
        <View style={{ margin: 15 }}>
          <View style={{ width: "100%", alignItems: "flex-end", zIndex: 1 }}>
            <View
              style={{
                margin: 10,
                width: 120,
              }}
            >
              <CategoryPicker />
            </View>
          </View>
          {imageUrl ? (
            <View>
              <Image
                source={{ uri: imageUrl }}
                style={{
                  width: "100%",
                  paddingBottom: "100%",
                  borderRadius: 25,
                }}
              />
            </View>
          ) : (
            <View
              style={{
                alignItems: "center",
                width: "100%",
              }}
            >
              <TouchableOpacity
                style={{
                  width: "100%",
                  paddingTop: "40%",
                  paddingBottom: "40%",
                  borderStyle: "dashed",
                  borderWidth: 2,
                  borderRadius: 25,
                  borderColor: "#73968B",
                  justifyContent: "center",
                  alignItems: "center",
                }}
                onPress={uploadImage}
              >
                <AntDesign name="picture" size={40} color={"#73968B"} />
                <Text style={{ fontSize: 15, color: "#73968B" }}>
                  사진을 추가해주세요.
                </Text>
              </TouchableOpacity>
            </View>
          )}
          <Text style={styles.inputTitle}>의상 이름</Text>
          <TextInput
            placeholder="이름을 입력해주세요"
            placeholderTextColor={"#A2C3B9"}
            onChangeText={(text) => {
              changeDressName(text);
            }}
            style={styles.textInput}
          ></TextInput>
          <Text style={styles.inputTitle}>해시태그</Text>
          <View style={{ margin: 9, marginTop: 0, zIndex: 1 }}>
            <HashTagPicker changeHashTag={changeHashTag} />
          </View>
          <TouchableOpacity
            style={styles.saveBtn}
            onPress={() =>
              addDress(dressName, "high", hashTag, imageUrl, form, navigation)
            }
          >
            <Text style={{ color: "white", fontSize: 17 }}>저장하기</Text>
          </TouchableOpacity>
        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}

const styles = StyleSheet.create({
  keyboard: {
    flex: 1,
  },
  categoryBox: {
    backgroundColor: "white",
    padding: 5,
    paddingRight: 10,
    paddingLeft: 10,
    borderRadius: 10,
  },
  inputTitle: {
    margin: 15,
    fontSize: 17,
    color: "#456A5A",
  },
  textInput: {
    margin: 15,
    marginTop: 0,
    fontSize: 15,
    borderBottomWidth: 1,
    padding: 5,
    borderBottomColor: "#A2C3B9",
  },
  saveBtn: {
    backgroundColor: "#3B5448",
    margin: 25,
    height: 50,
    borderRadius: 25,
    justifyContent: "center",
    alignItems: "center",
  },
});
