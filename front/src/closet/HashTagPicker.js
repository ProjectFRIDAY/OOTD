import { useEffect, useState } from "react";
import DropDownPicker from "react-native-dropdown-picker";

export default function HashTagPicker({ changeHashTag }) {
  const [open, setOpen] = useState(false);
  const [value, setValue] = useState([]);
  const [items, setItems] = useState([
    { label: "종류", value: "종류" },
    { label: "아우터", value: "아우터", parent: "종류" },
    { label: "가디건", value: "가디건", parent: "종류" },
    { label: "베스트", value: "베스트", parent: "종류" },
    { label: "자켓", value: "자켓", parent: "종류" },
    { label: "블레이저", value: "블레이저", parent: "종류" },
    { label: "디테일", value: "디테일" },
    { label: "버튼", value: "버튼", parent: "디테일" },
  ]);

  useEffect(() => {
    changeHashTag(value);
  });

  return (
    <DropDownPicker
      open={open}
      value={value}
      items={items}
      setOpen={setOpen}
      setValue={setValue}
      setItems={setItems}
      placeholder={"해시태그"}
      placeholderStyle={{
        color: "#A2C3B9",
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
        borderBottomWidth: 1,
        borderBottomColor: "#A2C3B9",
        backgroundColor: "transparent",
        minHeight: 30,
      }}
      multiple={true}
      mode={"BADGE"}
      badgeColors={"#B4D0C5"}
      showBadgeDot={false}
      searchable={true}
      categorySelectable={false}
    />
  );
}
