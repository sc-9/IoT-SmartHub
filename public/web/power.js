class Power extends React.Component {

	constructor(props) {
	super(props);
	this.state = {
	powerData: [],
	power: 0
	};
	}
	
	componentDidMount() {
	this.getPowerData();
	setInterval(this.getPowerData, 1000);
	}
	
	render() {
	var powerData = this.state.powerData;
	
	if (powerData.length == 0)
	return <div>There is no data.</div>;
	var last = powerData[powerData.length-1];
	return (<div>
	Last power reading: {last.power} Watts, {last.date} {last.time}
	</div>);
	}
	
	
	updatePlugsssss(plugs) {
	// console.debug("Rajesh 6: " + JSON.stringify(plugs));
	
	for (var i = 0; i < plugs.length; ++i) {
	// if (this.props.plugSelected.name == plugs[i].name) {
	// this.props.updatePlugSelected(plugs[i]);
	// return;
	// }
	this.state.power = this.setState({power: parseInt(plugs[i].power)})
	console.loh("========================"+plugs[0].name);
	console.log(plugs[i].name);
	console.log(plugs[i].power);
	console.log(plugs[i].state);
	}
	return
	}
	
	getPowerData = () => {
	// for simplicity, we generate some fake data here
	var now = new Date();
	var date = now.toLocaleDateString();
	var time = now.toLocaleTimeString();
	
	var action = "on";
	var url = "../api/plugs/" + name + "?action=" + action;
	fetch("../api/plugs")
	.then(rsp => rsp.json())
	.then(data => this.updatePlugsssss(data))
	.catch(err => console.debug("Plugs: error " + JSON.stringify(err)));
	//var p = plugs.power;
	
	var powerData = [{date: date, time: time, power: 100}];
	if (this.state.powerData.length != 0) {
	powerData = this.state.powerData.slice(0);
	var last = powerData[powerData.length-1].power;
	var delta = Math.floor(Math.random()*21)-10; // [-10, 10]
	//var delta = p;
	//var delta = JSON.stringify(plugs.power);
	powerData.push({date: date, time: time, power: this.state.power});
	}
	
	// discard old data
	if (powerData.length > 20)
	powerData = powerData.slice(powerData.length-20);
	
	// update state
	this.props.display.setData(powerData);
	this.setState({powerData: powerData});
	}
	}
	
	// export
	window.Power = Power;