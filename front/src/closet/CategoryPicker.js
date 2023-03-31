import { useEffect, useState } from "react";
import DropDownPicker from "react-native-dropdown-picker";

export default function CategoryPicker({ handleSetCategory }) {
  const [open, setOpen] = useState(false);
  const [value, setValue] = useState(null);
  const [items, setItems] = useState([
    { label: "아우터", value: "OUTER" },
    { label: "상의", value: "TOP" },
    { label: "하의", value: "BOTTOMS" },
    { label: "신발", value: "SHOES" },
  ]);

  useEffect(() => {
    handleSetCategory(value);
  });

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
