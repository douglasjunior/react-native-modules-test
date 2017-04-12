import React, { Component } from 'react'
import {
    NativeModules,
    Text,
    View
} from 'react-native';

const MeuConsole = NativeModules.MeuConsole;

class MeuComponente extends Component {

    constructor(props) {
        super(props);
        MeuConsole.log("constructor")

        // MeuConsole.logCallback("exibindo log com callback", function (error) {
        //     console.log("callback error")
        //     console.warn(error);
        // }, function () {
        //     console.log("callback ok")
        // });

        // MeuConsole.logPromise("exibindo log na promise")
        //     .then(() => {
        //         console.log("promise ok")
        //     })
        //     .catch((ex) => {
        //         console.log("promise error")
        //         console.warn(ex);
        //     });

        // MeuConsole.logObject({
        //     texto: "Testando",
        //     numero: 150
        // });
    }

    componentWillMount() {
        MeuConsole.log("componenteWillMount")
    }

    componentDidMount() {
        MeuConsole.log("componenteDidMount")
    }

    render() {
        return (
            <View>
                <Text>Este é o meu componente no {this.props.plataforma}!</Text>
            </View>
        )
    }
}

export default MeuComponente