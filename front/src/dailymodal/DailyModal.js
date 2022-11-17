import React from "react";
import { useState } from "react";
import { Modal, Text, View, StyleSheet, TouchableOpacity } from "react-native";

export default function DailyModal({
  openDayModal,
  closeDayModal,
  selectedDate,
}) {
  return (
    <Modal
      animationType="slide"
      transparent={true}
      visible={openDayModal}
      onRequestClose={() => {
        setDayModalVisible(!dayModalVisible);
      }}
    >
      <View style={styles.centeredView}>
        <View style={[styles.modalView, { height: "90%" }]}>
          <TouchableOpacity onPress={closeDayModal}>
            <View
              style={{
                width: 200,
                height: 30,
                backgroundColor: "#2B4036",
                justifyContent: "center",
              }}
            >
              <Text
                style={{
                  color: "white",
                  textAlign: "center",
                }}
              >
                닫기
              </Text>
            </View>
          </TouchableOpacity>
          <Text>{selectedDate}</Text>
        </View>
      </View>
    </Modal>
  );
}

const styles = StyleSheet.create({
  centeredView: {
    flex: 1,
    justifyContent: "flex-end",
    alignItems: "center",
    marginTop: 22,
  },
  modalView: {
    width: "100%",
    backgroundColor: "white",
    borderTopLeftRadius: 20,
    borderTopRightRadius: 20,
    padding: 35,
    alignItems: "center",
    shadowColor: "#000",
    shadowOpacity: 0.25,
    shadowRadius: 4,
    elevation: 5,
    padding: 0,
    paddingTop: 30,
  },
});
