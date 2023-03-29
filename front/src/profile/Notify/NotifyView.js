import { View, StyleSheet, FlatList, Text} from "react-native";
import React from "react";
import NotifyDataView from "./NotifyDataView";

const DATA = [
  {
    key: '1',
    name: '@name_1',
    notifydata: '신고함',
    date: '2023.03.14'
  },
  {
    key: '2',
    name: '@name_1',
    notifydata: '신고함',
    date: '2023.03.14'
  },
  {
    key: '3',
    name: '@name_1',
    notifydata: '신고함',
    date: '2023.03.14'
  },
  {
    key: '4',
    name: '@name_1',
    notifydata: '신고함',
    date: '2023.03.14'
  },
  {
    key: '5',
    name: '@name_1',
    notifydata: '신고함',
    date: '2023.03.14'
  },
];
  
export default function NotifyView () {
  
  return (
    <View>
      <View style={styles.TopBar}>
        <Text style={styles.TextStyle}>신고 내역 ? 건</Text>
        <Text style={styles.TextStyle}>ㅇㅇ순</Text>
      </View>
      <FlatList
      keyExtractor={item => item.key}
      data={DATA}
      renderItem={({item}) => <NotifyDataView name={item.name} notifydata={item.notifydata} DATE={item.date}/>}
      />
      <View style = {{height: 55}}/>
    </View>
  );
}

const styles = StyleSheet.create({
  TopBar: {
    backgroundColor: "white",
    height: 55,
		padding: 13,
		alignItems: "center",
		flexDirection: 'row',
    justifyContent: 'space-between',
  },
	TextStyle: {
    color: "#456A5A",
    fontSize: 13.5,
    fontWeight: "700",
	}
})
