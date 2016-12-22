package com.lg.core.web;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class TreeBuilder {

	List<TreeBuilder.Node> nodes = new ArrayList<TreeBuilder.Node>();
	public TreeBuilder(List<Node> nodes) {
		super();
		this.nodes = nodes;
	}

	/**
	 * 
	 * 构建JSON树形结构
	 * 
	 * @return
	 */

	public String buildJSONTree() {
		List<Node> nodeTree = buildTree();
		Gson gson = new GsonBuilder().serializeNulls().create();
	    String s=gson.toJson(nodeTree);
		return s;
	}

	/**
	 * 构建树形结构
	 * @return
	 */
	public List<Node> buildTree() {
		List<Node> treeNodes = new ArrayList<Node>();
		List<Node> rootNodes = getRootNodes();
		for (Node rootNode : rootNodes) {
			buildChildNodes(rootNode);
			treeNodes.add(rootNode);
		}
		return treeNodes;
	}

	/**
	 * 
	 * 递归子节点 
	 * @param node
	 */
	public void buildChildNodes(Node node) {

		List<Node> children = getChildNodes(node);
		if (!children.isEmpty()) {
			for (Node child : children) {
				buildChildNodes(child);
			}
			node.setChildren(children);
		}
	}

	/**
	 * 
	 * 获取父节点下所有的子节点
	 * @param nodes
	 * @param pnode
	 * @return
	 */

	public List<Node> getChildNodes(Node node) {
		List<Node> childNodes = new ArrayList<Node>();
		for (Node n : nodes) {
			if (node.getId().equals(n.getPid())) {
				childNodes.add(n);
			}
		}
		return childNodes;
	}
	/**
	 * 
	 * 判断是否为根节点
	 * @param nodes
	 * @param inNode
	 * @return
	 */

	public boolean rootNode(Node node) {
		boolean isRootNode = true;
		for (Node n : nodes) {
			if (node.getPid().equals(n.getId())) {
				isRootNode = false;
				break;
			}
		}
		return isRootNode;
	}

	/**
	 * 
	 * 获取集合中所有的根节点
	 * @param nodes
	 * @return
	 */
	public List<Node> getRootNodes() {

		List<Node> rootNodes = new ArrayList<Node>();
		for (Node n : nodes) {
			if (rootNode(n)) {
				if(n.getPid().equals("-1"))rootNodes.add(n);
			}
		}
		return rootNodes;
	}
	
	public static class StateNode {
		
		private Boolean selected;

		public Boolean getSelected() {
			return selected;
		}

		public void setSelected(Boolean selected) {
			this.selected = selected;
		}
		
	}
	public static class Node {

		private String id;
		private String pid;
		private String text;
		private List<Node> children;
		private StateNode state;
		public Node() {
		}

		public Node(String id, String pid, String text,StateNode state) {
			super();
			this.id = id;
			this.pid = pid;
			this.text = text;
			this.state=state;
		}
		public Node(String id, String pid, String text) {
			super();
			this.id = id;
			this.pid = pid;
			this.text = text;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
			this.pid = pid;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public List<Node> getChildren() {
			return children;
		}

		public void setChildren(List<Node> children) {
			this.children = children;
		}

		public StateNode getState() {
			return state;
		}

		public void setState(StateNode state) {
			this.state = state;
		}
		
		
	}
}
