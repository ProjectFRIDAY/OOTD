import { useState } from "react";
import DropDownPicker from "react-native-dropdown-picker";

export default function RangePicker() {
  const [open, setOpen] = useState(false);
  const [value, setValue] = useState(null);
  const [items, setItems] = useState([
    { label: "전체 공개", value: "전체 공개" },
    { label: "맞팔로우 공개", value: "맞팔로우 공개" },
    { label: "나만 보기", value: "나만 보기" },
  ]);

  return (
    <DropDownPicker
      open={open}
      value={value}
      items={items}
      setOpen={setOpen}
      setValue={setValue}
      setItems={setItems}
      placeholder={"공개범위"}
      placeholderStyle={{
        color: "#456A5A",
      }}
      listMode="SCROLLVIEW"
      dropDownContainerStyle={{
        borderWidth: 0,
        borderRadius: 30,
        backgroundColor: "#F5F7F6",
      }}
      labelStyle={{
        color: "#456A5A",
      }}
      listItemLabelStyle={{
        color: "#456A5A",
      }}
      style={{
        borderWidth: 0,
        borderRadius: 30,
        backgroundColor: "#F5F7F6",
        minHeight: 30,
      }}
    />
  );
}
