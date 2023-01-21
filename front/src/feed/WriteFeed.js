import React from 'react';
import { View, Image, Text, TouchableOpacity, TextInput } from 'react-native';
import circleCamera from '../../assets/images/circlecamera.png'
import Share from '../../assets/images/share.png'
import Edit from '../../assets/images/edit.png'
import Delete from '../../assets/images/delete.png'

const styles = StyleSheet.create({
  ProfileImage: {
    position: "absolute",
    width: 173,
    height: 173,
    left: 101,
    top: 149,
    backgroundColor: "rgba(255, 255, 255, 0.6)",
    boxShadow: "4px 4px 4px rgba(0, 0, 0, 0.1)",
    borderRadius: 50,
    alignItems: "center",
    justifyContents: "center",
  },
  CircleCameraBtn: {
    position: "absolute",
    width: 49,
    height: 49,
    left: 221,
    top: 273,
  },
  shareBtn: {
    position: "absolute",
    width: 19,
    height: 18,
    left: 261,
    top: 328,
  },
  editBtn: {
    position: "absolute",
    width: 20,
    height: 21,
    left: 294,
    top: 325,
  },
  deleteBtn: {
    position: "absolute",
    width: 19,
    height: 21,
    left: 325,
    top: 325,
  },
  TextCard: {
    position: "absolute",
    width: 333,
    height: 330,
    left: 21,
    top: 357,
    backgroundColor: "rgba(255, 255, 255, 0.6)",
    borderRadius: 2,
  },
  TextLayout: {
    position: "absolute",
    width: 295,
    height: 276,
    left: 19,
    top: 17,
  },
  horizonLine: {
    position: "absolute",
    width: 295,
    height: 0,
    left: 40,
    border: "1px solid #4981168",
    borderRadius: 2,
  },
})

const HorizonLine = (props) => (
  <View style={[style.horizonLine, props.style]}>
    {props.children}
  </View>
);

export default function WriteFeed(){
  return (
    <View>
      <View style={styles.ProfileImage}>
        <Text style={{fontSize: 50, color: "white"}}>S</Text>
      </View>
      <TouchableOpacity style={styles.CircleCameraBtn}>
        <Image source={circleCamera} />
      </TouchableOpacity>
      <TouchableOpacity style={styles.shareBtn}>
        <Image source={Share} />
      </TouchableOpacity>
      <TouchableOpacity style={styles.editBtn}>
        <Image source={Edit} />
      </TouchableOpacity>
      <TouchableOpacity style={styles.deleteBtn}>
        <Image source={Delete} />
      </TouchableOpacity>
      <View style={styles.TextCard}>
        <View style={styles.TextLayout}>
          <HorizonLine style={{ top: 374 }} />
          <HorizonLine style={{ top: 376 }} />
          <TextInput 
            style={{
              position: "absolute",
              width: 211,
              height: 12,
              left: 52,
              top: 388,
              fontStyle: 'normal',
              fontWeight: 400,
              fontSize: 13,
              lineHeight: 13,
              color: "#AFC2BA",
            }}
            placeholder="제목을 입력해주세요."
          />
          <HorizonLine style={{ top: 413 }} />
          <TextInput 
            style={{
              position: "absolute",
              width: 268,
              height: 47,
              left: 52,
              top: 426,
              fontStyle: 'normal',
              fontWeight: 400,
              fontSize: 12,
              lineHeight: 12,
              color: "#AFC2BA",
            }}
            placeholder="ex) 상의: 2WAY 베이직 아노락 후드"
          />
          <HorizonLine style={{ top: 477 }} />
          <TextInput 
            style={{
              position: "absolute",
              width: 268,
              height: 133,
              left: 52,
              top: 494,
              fontStyle: 'normal',
              fontWeight: 400,
              fontSize: 12,
              lineHeight: 12,
              color: "#AFC2BA",
            }}
            placeholder="내용을 입력해주세요.
                          해시태그"
          />
          <HorizonLine style={{ top: 652 }} />
          <HorizonLine style={{ top: 654 }} />
        </View>
        
      </View>
    </View>
  )
}