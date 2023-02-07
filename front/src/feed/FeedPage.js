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
        style={{ width: 330, height: 330, borderRadius: 500 }}
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
        <Text>{item.title}</Text>
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
