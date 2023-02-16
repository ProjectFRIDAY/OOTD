// import React, { useEffect, useState } from "react";
// import {
//   View,
//   Image,
//   Text,
//   FlatList,
//   TouchableOpacity, // here
// } from "react-native";

// export default function FeedPage() {
//   // data = {
//   //   data: [],
//   //   page: 1, // here
//   // };
//   const [data, setData] = useState({ data: [], page: 1 });

//   const _renderItem = ({ item }) => (
//     <View style={{ width: "100%", alignItems: "center" }}>
//       <View
//         style={{
//           width: "100%",
//           padding: 20,
//           flexDirection: "row",
//           alignItems: "center",
//           justifyContent: "space-between",
//         }}
//       >
//         <View style={{ flexDirection: "row", alignItems: "center" }}>
//           <View
//             style={{
//               width: 37,
//               height: 37,
//               borderRadius: 100,
//               marginRight: 10,
//               backgroundColor: "#2B4036",
//             }}
//           />
//           <View>
//             <Text>@OOTD_Friday</Text>
//             <Text>닉네임</Text>
//           </View>
//         </View>
//         <TouchableOpacity>
//           <Image
//             source={require("../../assets/images/morebtn.png")}
//             style={{ width: 20, height: 17 }}
//           />
//         </TouchableOpacity>
//       </View>
//       <Image
//         source={{ uri: item.url }}
//         style={{
//           width: 330,
//           height: 330,
//           borderRadius: 500,
//         }}
//       />
//       <View style={{ width: "100%", padding: 20 }}>
//         <View style={{ flexDirection: "row" }}>
//           <TouchableOpacity style={{ marginBottom: 10, marginRight: 10 }}>
//             <Image source={require("../../assets/images/like.png")} />
//           </TouchableOpacity>
//           <TouchableOpacity style={{ marginBottom: 10 }}>
//             <Image source={require("../../assets/images/comment.png")} />
//           </TouchableOpacity>
//         </View>
//         <View style={{ flexDirection: "row", alignItems: "flex-end" }}>
//           <Text style={{ fontSize: 15, color: "#2B4036", marginRight: 15 }}>
//             @OOTD_Friday
//           </Text>
//           <Text style={{ fontSize: 14, color: "#2B4036", marginRight: 5 }}>
//             2022.12.16
//           </Text>
//           <Text style={{ fontSize: 14, color: "#2B4036" }}>결혼식 하객룩</Text>
//         </View>
//         <View>
//           <Text
//             numberOfLines={1}
//             style={{ width: "85%", fontSize: 14, color: "#2B4036" }}
//           >
//             {item.title}
//           </Text>
//         </View>
//         <Text>{item.id}</Text>
//       </View>
//     </View>
//   );

//   // _getData 함수 수정
//   const _getData = () => {
//     const url =
//       "https://jsonplaceholder.typicode.com/photos?_limit=10&_page=" +
//       this.data.page;
//     fetch(url)
//       .then((r) => r.json())
//       .then((data) => {
//         // setData(...data, {
//         //   data: data,
//         //   page: data.page + 1,
//         // });
//         console.log("hi");
//       });
//   };

//   useEffect(() => {
//     _getData();
//   }, []);

//   // here
//   const _handleLoadMore = () => {
//     _getData();
//   };
//   return (
//     <FlatList
//       data={data}
//       renderItem={_renderItem()}
//       keyExtractor={(item, index) => item.id}
//       onEndReached={_handleLoadMore()}
//       onEndReachedThreshold={1}
//     />
//   );
// }

import React from "react";
import {
  View,
  Image,
  Text,
  FlatList,
  TouchableOpacity, // here
} from "react-native";

export default class FeedPage extends React.Component {
  state = {
    data: [],
    page: 1, // here
  };

  _renderItem = ({ item }) => (
    <View style={{ width: "100%", alignItems: "center" }}>
      <View
        style={{
          width: "100%",
          padding: 20,
          flexDirection: "row",
          alignItems: "center",
          justifyContent: "space-between",
        }}
      >
        <View style={{ flexDirection: "row", alignItems: "center" }}>
          <View
            style={{
              width: 37,
              height: 37,
              borderRadius: 100,
              marginRight: 10,
              backgroundColor: "#2B4036",
            }}
          />
          <View>
            <Text>@OOTD_Friday</Text>
            <Text>닉네임</Text>
          </View>
        </View>
        <TouchableOpacity>
          <Image
            source={require("../../assets/images/morebtn.png")}
            style={{ width: 20, height: 17 }}
          />
        </TouchableOpacity>
      </View>
      <Image
        source={{ uri: item.url }}
        style={{
          width: 330,
          height: 330,
          borderRadius: 500,
        }}
      />
      <View style={{ width: "100%", padding: 20 }}>
        <View style={{ flexDirection: "row" }}>
          <TouchableOpacity style={{ marginBottom: 10, marginRight: 10 }}>
            <Image source={require("../../assets/images/like.png")} />
          </TouchableOpacity>
          <TouchableOpacity style={{ marginBottom: 10 }}>
            <Image source={require("../../assets/images/comment.png")} />
          </TouchableOpacity>
        </View>
        <View style={{ flexDirection: "row", alignItems: "flex-end" }}>
          <Text style={{ fontSize: 15, color: "#2B4036", marginRight: 15 }}>
            @OOTD_Friday
          </Text>
          <Text style={{ fontSize: 14, color: "#2B4036", marginRight: 5 }}>
            2022.12.16
          </Text>
          <Text style={{ fontSize: 14, color: "#2B4036" }}>결혼식 하객룩</Text>
        </View>
        <View>
          <Text
            numberOfLines={1}
            style={{ width: "85%", fontSize: 14, color: "#2B4036" }}
          >
            {item.title}
          </Text>
        </View>
        <Text>{item.id}</Text>
      </View>
    </View>
  );

  // _getData 함수 수정
  _getData = () => {
    const url =
      "https://jsonplaceholder.typicode.com/photos?_limit=10&_page=" +
      this.state.page;
    fetch(url)
      .then((r) => r.json())
      .then((data) => {
        this.setState({
          // data: this.data.data.concat(data),
          data: this.state.data.concat(data),
          page: this.state.page + 1,
        });
      });
  };

  componentDidMount() {
    this._getData();
  }

  // here
  _handleLoadMore = () => {
    this._getData();
  };

  render() {
    return (
      <FlatList
        data={this.state.data}
        renderItem={this._renderItem}
        keyExtractor={(item, index) => item.id}
        onEndReached={this._handleLoadMore}
        onEndReachedThreshold={1}
      />
    );
  }
}
