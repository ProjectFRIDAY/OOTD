import React from 'react';
import {StyleSheet, Text, TouchableOpacity} from 'react-native';

const NotifyData = ({name, notifydata, DATE}) => {
  return (
    <TouchableOpacity style={styles.container}>
      <Text style={styles.nametext}>{name}</Text>
      <Text style={styles.notifytext}>{notifydata}</Text>
      <Text style={styles.datetext}>{DATE}</Text>
    </TouchableOpacity>
  );
};

const styles = StyleSheet.create({
  container: {
    height: 80,
    backgroundColor: 'white',
    justifyContent: "space-around",
    padding:5
  },
  nametext: {
    fontSize: 17,
    marginLeft: 10,
    color: '#767577',
  },
  notifytext: {
    marginLeft: 10,
    fontSize: 16,
    fontWeight: "600",
  },
  datetext: {
    marginLeft: 10,
    color: '#767577',
    fontSize: 11,
  }
});

export default NotifyData;