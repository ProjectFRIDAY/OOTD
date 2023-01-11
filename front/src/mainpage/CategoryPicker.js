import { useState } from "react";
import DropDownPicker from "react-native-dropdown-picker";

export default function CategoryPicker() {
  const [open, setOpen] = useState(false);
  const [value, setValue] = useState(null);
  const [items, setItems] = useState([
    { label: "전체", value: "전체" },
    { label: "아우터", value: "아우터" },
    { label: "상의", value: "상의" },
    { label: "하의", value: "하의" },
    { label: "신발", value: "신발" },
  ]);

  return (
    <DropDownPicker
      open={open}
      value={value}
      items={items}
      setOpen={setOpen}
      setValue={setValue}
      setItems={setItems}
      placeholder={"카테고리"}
      placeholderStyle={{
        color: "#456A5A",
      }}
      listMode="SCROLLVIEW"
      dropDownContainerStyle={{
        borderWidth: 0,
        borderRadius: 30,
        backgroundColor: "#FFFFFF",
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
        backgroundColor: "#FFFFFF",
        minHeight: 30,
      }}
    />
  );
}
