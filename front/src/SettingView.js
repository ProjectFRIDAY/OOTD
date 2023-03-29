import { Text, StyleSheet, View, Switch, TouchableOpacity,Image, Alert} from "react-native";
import React, {useState} from 'react';
import ArrowImage from '../assets/images/Greater-than_sign.png';



export default function SettingView ( ) {
  
  const [isEnabled, setIsEnabled] = useState(false);
  const toggleSwitch = () => setIsEnabled(previousState => !previousState);

  const logoutBtn = () => {
    Alert.alert('로그아웃','로그아웃 하시겠습니까?',[
      {
        text: '로그아웃',
      },
      {
        text: '취소',
        style: 'cancel'
      }
    ])
  }

  const memberBtn = () => {
    Alert.alert('회원탈퇴',
    '회원 탈퇴 시 모든 기록이 삭제되며,\n삭제된 데이터는 복구할 수 없습니다.\n회원 탈퇴를 하시겠습니까?',
    [
      {
        text: '회원 탈퇴',
      },
      {
        text: '취소',
      }
    ])
  }

  return (
    <View style = {styles.container}>
      <View style = {styles.viewStyle}>
        <Text style = {styles.TextStyle}>푸시 알람 받기</Text>
        <Switch
        trackColor={{false: '#767577', true: '#2B4036'}}
        thumbColor={'#ffffff'}
        onValueChange={toggleSwitch}
        value={isEnabled}
        />
      </View>
      <TouchableOpacity style = {styles.viewStyle}>
        <Text style = {styles.TextStyle}>이용약관</Text>
        <Image
        source={ArrowImage}
        style = {{width: 35, height: 20, resizeMode:'contain'}}/>
      </TouchableOpacity>
      <TouchableOpacity style = {styles.viewStyle}>
        <Text style = {styles.TextStyle}>개인 정보 처리 방침</Text>
        <Image
        source={ArrowImage}
        style = {{width: 35, height: 20, resizeMode:'contain'}}/>
      </TouchableOpacity>
      <TouchableOpacity style = {styles.viewStyle} onPress = {logoutBtn}>
        <Text style = {styles.TextStyle}>로그아웃</Text>
        <Image
        source={ArrowImage}
        style = {{width: 35, height: 20, resizeMode:'contain'}}/>
      </TouchableOpacity>
      <TouchableOpacity style = {styles.viewStyle} onPress = {memberBtn}>
        <Text style = {styles.TextStyle}>회원 탈퇴</Text>
        <Image
        source={ArrowImage}
        style = {{width: 35, height: 20, resizeMode:'contain'}}/>
      </TouchableOpacity>
    </View>
  );
}



const styles = StyleSheet.create({
  container: {
    backgroundColor: "white",
    height: "40%",
    padding: 20,
  },
  viewStyle: {
    alignItems: "center",
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  TextStyle: {
    color: "#456A5A",
    fontSize: 13.5,
    fontWeight: "700",
  },
})